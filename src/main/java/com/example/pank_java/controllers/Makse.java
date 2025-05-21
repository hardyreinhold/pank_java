package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Makse {

    @FXML private TextField ibanField;
    @FXML private TextField summaField;


    @FXML
    private void saadaMakse() {
        String iban = ibanField.getText();
        String summa = summaField.getText();
        System.out.println("Saadan makse: IBAN=" + iban + ", Summa=" + summa);

    }

    @FXML
    private void tagasi() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/pank_java/account.fxml")
        );
        Parent root = loader.load();
        Main.setTseen(root, 700, 300);

    }
}