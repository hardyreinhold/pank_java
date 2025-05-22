package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Konto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import static com.example.pank_java.Main.getPank;

public class AccountController {
    @FXML private Label       totalLabel;      // Kokku vabad vahendid
    @FXML private Hyperlink   accName;         // Konto omaniku nimi/link
    @FXML private Label       ibanLabel;       // IBAN
    @FXML private Label       balance;         // Kontojääk
    @FXML private Label       available;       // Vabad vahendid
    @FXML private Label       currency;        // Valuuta
    @FXML private Button      copyButton;      // Kopeeri IBAN
    @FXML private Button      detailsButton;   // Näita detaile
    @FXML private Button      newPayment;      // Uus makse

    private Konto konto;

    public void setKonto(Konto konto) {
        this.konto = konto;
        populate();
    }

    private void populate() {
        NumberFormat fmt = NumberFormat.getNumberInstance(new Locale("et","EE"));
        fmt.setMinimumFractionDigits(2);

        double saldo = konto.getSummaKontol();
        totalLabel .setText(fmt.format(saldo) + " EUR");
        balance    .setText(fmt.format(saldo));
        available  .setText(fmt.format(saldo));
        currency   .setText("EUR");

        accName   .setText(konto.getKontoOmanik());
        ibanLabel .setText(konto.getKontoNumber());

        copyButton.setOnAction(e ->
                System.out.println("Kopeerisin IBANi: " + ibanLabel.getText())
        );
        detailsButton.setOnAction(e ->
                System.out.println("Näita detaile: " + konto)
        );
        newPayment.setOnAction(e -> {
            try {
                onNewPayment();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });



    }

    @FXML
    private void logiVälja(){
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/pank_java/login.fxml")
            );
            Main.setTseen(root, 400, 500);
            System.out.println("Logisin välja!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onNewPayment() throws IOException {
        System.out.println("Avan makse-dialoogi…");
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("makse.fxml")
        );
        Parent root = loader.load();

        Makse makse = loader.getController();
        makse.setKonto(konto);

        Main.setTseen(root, 300, 500);
    }

    // funktsioon salvestab hetkel tehtud toimingud faili
    @FXML
    private void salvestaToim() {
        Main.kirjutaKasutajadFaili("kasutajad.txt");
    }
}
