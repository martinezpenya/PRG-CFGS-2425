package es.martinezpenya.ejemplos.UD04;

public class Recursividad2 {

    public static void main(String[] args) {

        //factorial
        System.out.println(factorial(4));

    }

    /**
     * Método recursivo que calcula el factorial
     */
    public static int factorial(int n) {
        if (n == 0) {
            //Caso base: Se sabe el resultado directamente
            System.out.println("Caso base: n es igual a 0");
            return 1;
        } else {
            //Caso recursivo: Para calcularlo hay que invocar al método recursivo
            //El valor del nuevo parámetro de entradad se ha de modificar, de
            //manera que se vaya acercando al caso base
            System.out.println("Caso recursivo " + (n - 1)
                    + ": Se invoca al factorial(" + (n - 1) + ")");
            int resultado = n * factorial(n - 1);
            System.out.println("  cuyo resultado es: " + resultado);
            return resultado;
        }
    }
}