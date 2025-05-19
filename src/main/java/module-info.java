module com.example.pank_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pank_java to javafx.fxml;
    exports com.example.pank_java;
    exports com.example.pank_java.controllers;
    opens com.example.pank_java.controllers to javafx.fxml;
}