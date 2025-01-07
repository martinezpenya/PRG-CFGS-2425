package es.martinezpenya.ejemplos.UD10;

public class UD10_04_SingletonTest {
    static java.sql.Connection con = UD10_03_Singleton.getInstance().getConnection();
    public UD10_04_SingletonTest(){
        //De momento no hace nada
    }
}
