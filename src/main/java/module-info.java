module com.fundacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.fundacion to javafx.fxml;
    exports com.fundacion;
}
