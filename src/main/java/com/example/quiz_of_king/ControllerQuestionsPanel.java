package com.example.quiz_of_king;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerQuestionsPanel {
    @FXML
    Pane panel;

    public void clickBtnSubject(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        switch (button.getText()){
            case "مذهبی" -> setPanel(SubjectQuestion.Religious);
            case "ورزشی" -> setPanel(SubjectQuestion.Sports);
            case "جغرافیا" -> setPanel(SubjectQuestion.Geography);
            case "هنر" -> setPanel(SubjectQuestion.Art);
            case "ریاضی" -> setPanel(SubjectQuestion.Math);
            case "زبان" -> setPanel(SubjectQuestion.Language);
            case "هوش" -> setPanel(SubjectQuestion.IQ);
        }
    }
    public void setPanel(SubjectQuestion subjectQuestion) throws IOException {
        DataBase.subjectQuestion = subjectQuestion;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("table_question_panel.fxml"));
        Parent root = loader.load();
        panel.getChildren().add(root);
    }
    public void exit() throws IOException {
        Stage stage = (Stage) panel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Quiz Of King");
        stage.setScene(scene);
    }
}
