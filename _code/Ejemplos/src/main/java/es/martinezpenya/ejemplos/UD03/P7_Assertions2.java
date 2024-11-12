package es.martinezpenya.ejemplos.UD03;

public class P7_Assertions2 {
    public static void main(String[] args) {
        System.out.println("Probando Aserciones...");
        assert true : "Nunca veremos esto.";
        assert false : "Esto solo lo veremos si activamos las aserciones.";
    }
}