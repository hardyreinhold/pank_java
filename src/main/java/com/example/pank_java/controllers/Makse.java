package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Kasutaja;
import com.example.pank_java.java.Konto;
import com.example.pank_java.java.Pank;
import com.example.pank_java.java.RahaPolePiisavalt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class Makse {

    @FXML private TextField ibanField;
    @FXML private TextField summaField;
    @FXML private VBox vBox;

    private Konto konto;

    @FXML
    private void saadaMakse() {
        Pank pank = Main.getPank();
        String iban = ibanField.getText();
        String summa = summaField.getText();
        List<Kasutaja> kasutajad = pank.getKasutajaList();
        Konto saaja = null;
        for (Kasutaja kasutaja : kasutajad) {
            List<Konto> kasutajaKontod = kasutaja.getKontoList();

            for (Konto konto1 : kasutajaKontod) {
                if(konto1.getKontoNumber().equals(iban)) {
                    saaja = konto1;
                };
            }
        }

        if(!(saaja == null)){
            try {
                konto.lahutaKontolt(Double.parseDouble(summa));
                saaja.sisestaKontole(Double.parseDouble(summa));
                System.out.println("Saatsin makse: IBAN=" + iban + ", Summa=" + summa);
                Text confirmation = new Text("Makse sooritatud summas: " + summa);

                confirmation.setFill(Color.GREEN);
                confirmation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

                vBox.getChildren().add(confirmation);
            } catch (RahaPolePiisavalt e) {
                Text confirmation = new Text(e.getMessage());

                confirmation.setFill(Color.RED);
                confirmation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

                vBox.getChildren().add(confirmation);
            }

        }
        else{
            Text confirmation = new Text("Antud IBAN-i ei leitud.");

            confirmation.setFill(Color.RED);
            confirmation.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

            vBox.getChildren().add(confirmation);
        }


    }

    @FXML
    private void tagasi() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/pank_java/account.fxml")
        );

        // lean rooti
        Parent root = loader.load();

        // konto lehe populateimiseks
        AccountController ctrl = loader.getController();
        ctrl.setKonto(konto);

        Main.setTseen(root, 700, 300);

    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
}