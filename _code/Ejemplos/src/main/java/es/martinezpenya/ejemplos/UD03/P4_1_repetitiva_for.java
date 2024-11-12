package es.martinezpenya.ejemplos.UD03;

public class P4_1_repetitiva_for {
    /* En este ejemplo se utiliza la estructura repetitiva for
     * para representar en pantalla la tabla de multiplicar del siete
     */
    public static void main(String[] args) {
        // Declaración e inicialización de variables
        int numero = 7;
        //int contador;
        int resultado = 0;
        //Salida de información
        System.out.println("Tabla de multiplicar del " + numero);
        System.out.println(".............................. ");
        //Utilizamos ahora el bucle for
        for (int contador = 10; contador > 0; contador--) {
            /* La cabecera del bucle incorpora la inicialización de la variable
             * de control, la condición de multiplicación hasta el 10 y el
             * incremento de dicha variable de uno en uno en cada iteración del
             * bucle.
             * En este caso contador++ incrementará en una unidad el valor de
             * dicha variable.
             */
            resultado = contador * numero;
            System.out.println(numero + " x " + contador + " = " + resultado);
            /* A través del operador + aplicado a cadenas de caracteres,
             * concatenamos los valores de las variables con las cadenas de
             * caracteres que necesitamos para representar correctamente la
             * salida de cada multiplicación.
             */
        }
    }
}