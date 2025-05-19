package com.example.pank_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Scene tseen;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("login.fxml"));
        tseen = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(tseen);
        stage.show();
    }
    public static void setTseen(Parent root) {
        tseen.setRoot(root);
    }

    public static void main(String[] args) {
        launch();
    }
}