package es.martinezpenya.ejemplos.UD08._09_Ejemplo_3_5;

public class Profesor extends Persona {

    String especialidad;
    double salario;

    // Método getEspecialidad
    public String getEspecialidad() {
        return especialidad;
    }

    // Método getSalario
    public double getSalario() {
        return salario;
    }

    // Método setSalario
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método setEspecialidad
    public void setESpecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método getNombre
    @Override
    public String getNombre() {
        return "Profesor: " + this.nombre;
    }

    @Override
    public void mostrar() {
        // Llamada al método "mostrar" de la superclase
        super.mostrar();
        // A continuación mostramos la información "especializada" de esta subclase
        System.out.printf("Especialidad: %s\n", this.especialidad);
        System.out.printf("Salario: %7.2f euros\n", this.salario);
    }
}
