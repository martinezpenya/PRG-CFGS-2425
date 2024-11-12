package es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton;

public class SingletonTest {
    static java.sql.Connection con = Singleton.getInstance().getConnection();
    public SingletonTest(){
        //De momento no hace nada
    }
}
