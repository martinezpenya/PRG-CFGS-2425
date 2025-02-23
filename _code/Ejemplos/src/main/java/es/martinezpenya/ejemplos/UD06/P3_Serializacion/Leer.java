package es.martinezpenya.ejemplos.UD06.P3_Serializacion;

import java.io.*;

public class Leer {

    public static void main(String args[]) {
        Persona p1, p2, p3, p4;

        try {
            ObjectInputStream entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/empleats.ser")));
            p1 = (Persona) entrada.readObject();
            entrada.close();

            p2 = p1.getTutor();
            p3 = p2.getTutor();
            p4 = p3.getTutor();

            System.out.println(p4.getNombre());
            System.out.println(p4.getEdad());
            System.out.println(p4.getSalario());
            System.out.println(p1);

        } catch (ClassNotFoundException e) {
            System.out.println("Algun problema con las clases definidas.");
        } catch (IOException e) {
            System.out.println("Algun problema leyendo de disco.");
        }
    }
}