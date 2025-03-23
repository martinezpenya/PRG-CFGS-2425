package es.martinezpenya.ejemplos.UD07.P2_3_Listas;

import es.martinezpenya.ejemplos.UD07.Producto;

import java.util.ArrayList;

public class Ejemplo06 {

    public static void main(String[] args) {

        //Definimos 5 instancias de la clase Producto
        es.martinezpenya.ejemplos.UD07.Producto p1 = new es.martinezpenya.ejemplos.UD07.Producto("Pan", 6);
        es.martinezpenya.ejemplos.UD07.Producto p2 = new es.martinezpenya.ejemplos.UD07.Producto("Leche", 2);
        es.martinezpenya.ejemplos.UD07.Producto p3 = new es.martinezpenya.ejemplos.UD07.Producto("Manzanas", 5);
        es.martinezpenya.ejemplos.UD07.Producto p4 = new es.martinezpenya.ejemplos.UD07.Producto("Brocoli", 2);
        es.martinezpenya.ejemplos.UD07.Producto p5 = new es.martinezpenya.ejemplos.UD07.Producto("Carne", 2);

        //Definir un ArrayList
        ArrayList<es.martinezpenya.ejemplos.UD07.Producto> lista = new ArrayList<>();

        //Colocar instancias de producto en ArrayList
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        //Añadimos "Carne" en la posición 1 de la lista
        lista.add(1, p5);

        //Añadimos "Carne" en la última posición
        lista.add(p5);
        
        //Imprimir el contenido del ArrayList
        System.out.println(" - Lista con " + lista.size() + " elementos");
       
        for (es.martinezpenya.ejemplos.UD07.Producto p : lista) {
            System.out.println(p.getNombre() + " : " + p.getCantidad());
        }

        p5.setCantidad(99); //cambiamos la cantidad al producto, cambiará la lista?

        ((es.martinezpenya.ejemplos.UD07.Producto)lista.get(1)).setCantidad(66); //
        
        System.out.println(p5.getCantidad());
        
        //Imprimir el contenido del ArrayList
        System.out.println(" - Lista con " + lista.size() + " elementos");

        for (Producto p : lista) {
            System.out.println(p.getNombre() + " : " + p.getCantidad());
        }
        
        //Eliminar todos los valores del ArrayList
        lista.clear();
        System.out.println(" - Lista final con " + lista.size() + " elementos");
    }
}
