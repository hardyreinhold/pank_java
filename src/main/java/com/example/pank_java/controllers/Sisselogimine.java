package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Objects;

public class Sisselogimine {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML private void login() {
        System.out.println("Sisselogitud");
    }

    @FXML private void registreeri() {
        try {
            Parent registreeriRoot = FXMLLoader.load(
                    Objects.requireNonNull(Main.class.getResource("registreeri.fxml"))
            );
            Main.setTseen(registreeriRoot, 400, 400);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ei leidnud registreeri.fxml faili.");
        }
    }
}
