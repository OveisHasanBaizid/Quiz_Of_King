package com.example.quiz_of_king;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMainPanel {
    @FXML
    Label title;
    public void btnStart() throws IOException {
        Stage stage = (Stage) title.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Game");
        stage.setScene(scene);
    }
    public void btnQuestions() throws IOException {
        Stage stage = (Stage) title.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Game");
        stage.setScene(scene);
    }
    public void btnExit(){
        System.exit(0);
    }

}
