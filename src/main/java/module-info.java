module com.proyecto2.proyecto2cuestionarios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.proyecto2.proyecto2cuestionarios to javafx.fxml;
    exports com.proyecto2.proyecto2cuestionarios;
}