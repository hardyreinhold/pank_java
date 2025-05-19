package com.example.pank_java.controllers;

import com.example.pank_java.Main;
import com.example.pank_java.java.Kasutaja;
import com.example.pank_java.java.Konto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class ValiKonto {
    @FXML private ListView<Konto> listView;

    @FXML
    public void initialize() {
        Kasutaja user = Main.getPank().getPraeguneKasutaja();
        listView.setItems(FXCollections.observableArrayList(
                user.getKontoList()
        ));
    }

    @FXML
    private void onSelect() throws Exception {
        Konto chosen = listView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/pank_java/account.fxml")
        );
        Parent root = loader.load();

        // cast and set
        AccountController ctrl = loader.getController();
        ctrl.setKonto(chosen);

        Main.setTseen(root, 700, 300);
    }

    @FXML
    private void onNew() throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/pank_java/newaccount.fxml")
        );
        Main.setTseen(root, 400, 300);
    }
}
