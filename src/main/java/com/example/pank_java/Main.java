package com.example.pank_java;

import com.example.pank_java.java.Pank;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    private static Scene tseen;
    private static Pank pank;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        tseen = new Scene(root);
        pank = new Pank();
        stage.setTitle("Pank - Sisselogimine");
        stage.setMinWidth(250);
        stage.setMinHeight(250);
        stage.setScene(tseen);
        stage.show();
    }

    public static Pank getPank() {
        return pank;
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