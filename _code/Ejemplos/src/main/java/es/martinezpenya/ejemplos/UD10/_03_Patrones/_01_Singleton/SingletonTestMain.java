package es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton;

public class SingletonTestMain {
    public static void main(String[] args) {
        System.out.println("Usamos el patrón Singleton...");
        SingletonTest t1=new SingletonTest();
        SingletonTest t2=new SingletonTest();
        SingletonTest t3=new SingletonTest();
        SingletonTest t4=new SingletonTest();
        System.out.println("Aunque hemos creado 4 objetos de tipo test, solo se abre una conexión");
    }
}
