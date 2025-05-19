package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Konto;
import com.example.pank_java.java.Pank;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class UusKonto {
    @FXML private TextField vanusField;
    @FXML private TextField algSumma;

    @FXML
    private void onCreate() throws Exception {
        Pank pank = Main.getPank();

        int vanus   = Integer.parseInt(vanusField.getText().trim());
        double summa = Double.parseDouble(algSumma.getText().trim());

        // 1) Loo uus konto
        Konto uus = pank.looKonto(vanus, summa);

        // 2) Lae account.fxml (sinu dashboard)
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/pank_java/account.fxml")
        );
        Parent root = loader.load();

        // 3) Casti õigesse controller-klasse
        AccountController ctrl = loader.getController();
        ctrl.setKonto(uus);

        // 4) Vaheta stseen
        Main.setTseen(root, 700, 300);
    }

    @FXML
    private void onBack() throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/pank_java/login.fxml")
        );
        Main.setTseen(root, 400, 250);
    }
}
