package com.example.quiz_of_king;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        DataBase.readQuestionFromFile();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 400);
        stage.setTitle("Quiz Of King");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}