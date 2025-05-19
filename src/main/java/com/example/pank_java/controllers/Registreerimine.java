package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Kasutaja;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

import static com.example.pank_java.Main.getPank;
public class Registreerimine {
    @FXML private TextField kasutajaNimi;
    @FXML private PasswordField pass1;
    @FXML private PasswordField pass2;
    @FXML private VBox vBox;

    @FXML private void tagasi() {
        try {
            Parent tagasiRoot = FXMLLoader.load(
                    Objects.requireNonNull(Main.class.getResource("login.fxml"))
            );
            Main.setTseen(tagasiRoot, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ei leidnud login.fxml faili.");
        }

        System.out.println(getPank().getKasutajaList());
    }

    @FXML private void registreeri() {

        Kasutaja registreeritud = getPank().lisaKasutaja(kasutajaNimi.getText(), pass1.getText(), pass2.getText());

        if (registreeritud != null) {

            Text confirmation = new Text("Registreeritud!");

            confirmation.setFill(Color.GREEN);
            confirmation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");


            vBox.getChildren().add(confirmation);
        } else {
            Text confirmation = new Text("Registreerimine ebaõnnestus!");

            confirmation.setFill(Color.RED);
            confirmation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

            vBox.getChildren().add(confirmation);
        }
    }
}
