package com.example.pank_java;

import com.example.pank_java.java.Kasutaja;
import com.example.pank_java.java.Pank;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static Scene tseen;
    private static Pank pank;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        tseen = new Scene(root);
        pank = new Pank();
        loeKasutajadFailist("kasutajad.txt");
        System.out.println(pank.getKasutajaList());
        stage.setTitle("Pank - Sisselogimine");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.setScene(tseen);
        stage.show();
    }

    public static Pank getPank() {
        return pank;
    }

    public static void loeKasutajadFailist(String failinimi) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(failinimi)))) {
            String rida = br.readLine();
            while(rida != null) {
                String[] tükid = rida.split("@");
                String[] kasutaja = tükid[0].split(";");
                Kasutaja vaadeldav = new Kasutaja(kasutaja[0], kasutaja[1], Integer.parseInt(kasutaja[2]));
                pank.lisaKasutaja(vaadeldav);

                for (int i = 1; i < tükid.length; i++) {
                    String[] konto = tükid[i].split(";");
                    pank.looKonto(vaadeldav, konto[0],Double.parseDouble(konto[1]));
                }
                rida = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //meetod tseeni muutmiseks
    public static void setTseen(Parent root, double width, double height) {
        tseen.setRoot(root);
        Stage stage = (Stage) tseen.getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setMinWidth(width);
        stage.setMinHeight(height);
    }



    public static void main(String[] args) {
        launch();
    }
}