package es.martinezpenya.ejemplos._Otros;

/**
 * @author davpen
 */
public class Aleatorio {
    public static void main(String[] args) {
        System.out.print((int) ((Math.random() * 24) + 2));
        int direccion = (int) ((Math.random() * 2) + 1);
        System.out.println((direccion == 1) ? " ↑ amunt ↑" : " ↓ avall ↓");
    }
}