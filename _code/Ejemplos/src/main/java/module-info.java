module es.martinezpenya.ejemplos {

    requires javafx.controls;
    requires com.zaxxer.hikari;
    requires java.sql;

    opens es.martinezpenya.ejemplos.UD09._01_EjemplosBasicos to javafx.fxml;
    exports es.martinezpenya.ejemplos.UD09._01_EjemplosBasicos;
    opens es.martinezpenya.ejemplos.UD09._02_VBoxHBox to javafx.fxml;
    exports es.martinezpenya.ejemplos.UD09._02_VBoxHBox;
    opens es.martinezpenya.ejemplos.UD09._03_StackPane to javafx.fxml;
    exports es.martinezpenya.ejemplos.UD09._03_StackPane;
    opens es.martinezpenya.ejemplos.UD09._04_Pane to javafx.fxml;
    exports es.martinezpenya.ejemplos.UD09._04_Pane;
    opens es.martinezpenya.ejemplos.UD09._05_GridPane to javafx.fxml;
    exports es.martinezpenya.ejemplos.UD09._05_GridPane;
}