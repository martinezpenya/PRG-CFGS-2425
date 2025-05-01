package es.martinezpenya.ejemplos.UD11._4_5_Empleados;

import javax.persistence.*;
import java.util.List;

public final class TestEmpleado {

    public static void main(String[] args)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("src/main/java/es/martinezpenya/ejemplos/UD11/_4_5_Empleados/db/test.odb");
        EntityManager em = emf.createEntityManager();

        //crear empleado
        Empleado empleado = new Empleado("David", "Martinez", "Peña");

        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();

        //crear empleado con dirección
        Empleado empleado2 = new Empleado("David", "Martinez", "Peña");
        Direccion direccion = new Direccion("Carlet", "España");
        empleado2.setDireccion(direccion);

        em.getTransaction().begin();
        em.persist(empleado2);
        em.getTransaction().commit();

        //crear empleado con gerente
        Empleado empleadoConGerente = new Empleado("Samuel", "Perez", "Garcia");
        empleadoConGerente.setGerente(empleado2);

        em.getTransaction().begin();
        em.persist(empleadoConGerente);
        em.getTransaction().commit();

        //recuperación del nombre del Gerente
        Empleado empleado3 = em.find(Empleado.class, 3);
        Empleado gerente3 = empleado3.getGerente(); // puede estar vacio por el FetchType.LAZY
        String nombreGerente = gerente3.getNombre();

        //actualizar campo
        Empleado empleado4 = em.find(Empleado.class, 2);
        em.getTransaction().begin();
        empleado4.setApellido1("Otroapellido");
        em.getTransaction().commit();

        //eliminar empleado
        Empleado empleado5 = em.find(Empleado.class, 1);
        em.getTransaction().begin();
        em.remove(empleado5);
        em.getTransaction().commit();

        //Consultas

        Query q1 = em.createQuery("SELECT e FROM Empleado e");
        List results1 = q1.getResultList();

        TypedQuery<Empleado> q2 = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        List<Empleado> results2 = q2.getResultList();

        for (Empleado e : results2) {
            System.out.println(e.getNombre());
        }

        TypedQuery<Long> query3 = em.createQuery("SELECT COUNT(e) FROM Empleado e", Long.class);
        long numeroEmpleados = query3.getSingleResult();

        Query query4 = em.createQuery("SELECT e FROM Empleado e WHERE e.nombre='David'");
        Empleado empleado6 = (Empleado) query4.getSingleResult(); //podria provocar una excepción si hay más de un empleado llamado David

        //Eliminar instancias de Empleado
        em.getTransaction().begin();
        int count = em.createQuery("DELETE FROM Empleado").executeUpdate();
        em.getTransaction().commit();

        //Actualizar todos los Empleados
        em.getTransaction().begin();
        int count2 = em.createQuery("UPDATE Empleado SET apellido1 = 'Martinez'").executeUpdate();
        em.getTransaction().commit();


        em.close();
        emf.close();
    }

    public Empleado getEmpleadoPorNombre(EntityManager em, String nombre) {
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.nombre = :nombre", Empleado.class);
        return query.setParameter("nombre", nombre).getSingleResult();
    }

    public Empleado getEmpleadoPorNombreOrdinal(EntityManager em, String nombre) {
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.nombre = ?1", Empleado.class);
        return query.setParameter(1, nombre).getSingleResult();
    }

}