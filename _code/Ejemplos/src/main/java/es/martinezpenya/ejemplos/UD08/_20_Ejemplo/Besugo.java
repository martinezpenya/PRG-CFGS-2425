package es.martinezpenya.ejemplos.UD08._20_Ejemplo;

public class Besugo extends Animal{
    protected double peso;

    public Besugo(String nombre, double peso) {
        super(nombre);
        this.peso = peso;
    }

    public Besugo(String nombre) {
        super(nombre);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

//    @Override
//    public String toString() {
//        return "Besugo{" +
//                "peso=" + peso +
//                ", nombre='" + nombre + '\'' +
//                '}';
//    }
}
