package es.martinezpenya.ejemplos.UD10;

public class UD10_05_SingletonTestMain {
    public static void main(String[] args) {
        System.out.println("Usamos el patrón Singleton...");
        UD10_04_SingletonTest t1=new UD10_04_SingletonTest();
        UD10_04_SingletonTest t2=new UD10_04_SingletonTest();
        UD10_04_SingletonTest t3=new UD10_04_SingletonTest();
        UD10_04_SingletonTest t4=new UD10_04_SingletonTest();
        System.out.println("Aunque hemos creado 4 objetos de tipo test, solo se abre una conexión");
    }
}
