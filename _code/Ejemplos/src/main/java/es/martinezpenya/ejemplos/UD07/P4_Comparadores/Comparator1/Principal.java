package es.martinezpenya.ejemplos.UD07.P4_Comparadores.Comparator1;

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        TreeSet<Objeto> ts = new TreeSet<>(new ComparadorDeObjetos());
        LinkedHashSet<Objeto> al = new LinkedHashSet<>();

        Objeto o1= new Objeto(0, 1);
        ts.add(o1);
        al.add(o1);

        ts.add(new Objeto(1, 2));
        ts.add(new Objeto(4, 5));
        ts.add(new Objeto(2, 3));

        al.add(new Objeto(1, 2));
        al.add(new Objeto(4, 5));
        al.add(new Objeto(2, 3));

        for (Objeto o : ts) {
            System.out.println(o);
        }

        //Collections.sort(al, new ComparadorDeObjetos());
        for (Objeto o : al) {
            System.out.println(o);
        }
    }
}
