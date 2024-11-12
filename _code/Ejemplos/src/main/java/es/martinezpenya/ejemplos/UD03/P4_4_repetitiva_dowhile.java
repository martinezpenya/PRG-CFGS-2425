package es.martinezpenya.ejemplos.UD03;

public class P4_4_repetitiva_dowhile {

    public static void main(String[] args) {
        // Declaración e inicialización de variables
        int numero = 7;
        int contador;
        int resultado = 0;

        //Salida de información
        System.out.println("Tabla de multiplicar del " + numero);
        System.out.println(".............................. ");
        //Utilizamos ahora el bucle do-while
        contador = 1; //inicializamos la variable contadora
        do {
            resultado = contador * numero;
            System.out.println(numero + " x " + contador + " = " + resultado);
            //Modificamos el valor de la variable contadora, para hacer que el
            //bucle pueda seguir iterando hasta llegar a finalizar
            contador++;
        } while (contador <= 10); //Establecemos la condición del bucle
    }
}