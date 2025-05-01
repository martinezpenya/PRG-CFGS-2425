package es.martinezpenya.ejemplos.UD11._4_1_Entidad;

import javax.persistence.*;
import java.util.ArrayList;

public final class TestEntidad {

    public static void main(String[] args)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("src/main/java/es/martinezpenya/ejemplos/UD11/_4_1_Entidad/db/test.odb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Entidad e = new Entidad("test", 3);
        em.persist(e);
        em.getTransaction().commit();

        Query query = em.createQuery("SELECT name FROM Entidad e");
        ArrayList<Entidad> resultList = (ArrayList<Entidad>) query.getResultList();
        System.out.println(resultList);

        em.close();
        emf.close();
    }

}