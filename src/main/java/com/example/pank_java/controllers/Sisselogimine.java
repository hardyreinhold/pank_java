package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Kasutaja;
import com.example.pank_java.java.Pank;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.pank_java.Main.getPank;

public class Sisselogimine {
    @FXML private TextField    kasutajaNimi;
    @FXML private PasswordField parool;

    @FXML
    private void login() {
        try {
            Pank pank = getPank();
            Kasutaja user = pank.logiSisse(
                    kasutajaNimi.getText().trim(),
                    parool.getText().trim()
            );
            if (user == null) {
                System.out.println("Vale kasutajanimi või parool");
                return;
            }

            // valime, kumba FXML-i laadime
            String fxmlName = user.getKontoList().isEmpty()
                    ? "newaccount.fxml"
                    : "accountSelect.fxml";

            // tee ressurssitee
            String resPath = "/com/example/pank_java/" + fxmlName;

            // laeme FXML-i
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(resPath)
            );
            Parent root = loader.load();  // <--- ei vea nulliga üles

            // lõpuks vaheta stseen (same size for both)
            Main.setTseen(root, 400, 300);

        } catch (IOException e) {
            // kas FXML-i ei leitud või mõni muu I/O viga
            e.printStackTrace();
            System.err.println("Ei leia või ei saa laadida: " + e.getMessage());
        }
    }

    @FXML
    private void registreeri() {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/pank_java/registreeri.fxml")
            );
            Main.setTseen(root, 400, 500);
            System.out.println(getPank().getKasutajaList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
