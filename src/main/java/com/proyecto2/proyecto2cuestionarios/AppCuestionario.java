package com.proyecto2.proyecto2cuestionarios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppCuestionario extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppCuestionario.class.getResource("principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1002, 602);
        stage.setTitle("Proyecto Cuestionarios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}