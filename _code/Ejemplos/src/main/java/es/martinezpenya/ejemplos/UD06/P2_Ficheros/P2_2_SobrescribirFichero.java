package es.martinezpenya.ejemplos.UD06.P2_Ficheros;

import java.io.*;

public class P2_2_SobrescribirFichero {

    public static void main(String[] args) {
        try (FileWriter f = new FileWriter("src/texto.txt", false);) {
            f.write("Este texto se añade en el fichero\n\r");

        } catch (IOException e) {
            System.out.println("Problema al abrir o escribir ");
        }
    }
}