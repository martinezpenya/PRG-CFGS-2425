package es.martinezpenya.ejemplos.UD07.P4_Comparadores.Comparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Objeto> ts = new ArrayList<>();

        ts.add(new Objeto(0, 1));
        ts.add(new Objeto(1, 2));
        ts.add(new Objeto(4, 5));
        ts.add(new Objeto(2, 3));

        Collections.sort(ts);
        Collections.reverse(ts);
        for (Objeto o : ts) {
            System.out.println(o);
        }

    }
}
