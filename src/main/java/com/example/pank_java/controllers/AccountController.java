package com.example.pank_java.controllers;

import com.example.pank_java.java.Konto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.text.NumberFormat;
import java.util.Locale;

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
        newPayment.setOnAction(e -> onNewPayment());
    }

    @FXML
    private void onNewPayment() {
        System.out.println("Avan makse-dialoogi…");
        // TODO: Avage eraldi makse‐dialog
    }
}
