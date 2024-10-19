package UD03;

import java.util.Scanner;

public class P7_Assertions1 {
    // Programa Java para demostrar el uso de las assertions
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int age = entrada.nextInt();
        assert (age >= 18): "No puede votar";
        System.out.println("La edad del votante es de " + age);
    }
}