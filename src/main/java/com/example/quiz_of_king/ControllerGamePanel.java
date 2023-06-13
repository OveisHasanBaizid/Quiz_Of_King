package com.example.quiz_of_king;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerGamePanel {
    @FXML
    TextField textFieldSubjectQuestion;
    @FXML
    Label labelPlayer1, labelPlayer2;

    @FXML
    Label labelTextQuestion1, labelTextQuestion2;

    @FXML
    ToggleGroup group1, group2;

    @FXML
    RadioButton rb1_1, rb1_2, rb1_3, rb1_4;
    @FXML
    RadioButton rb2_1, rb2_2, rb2_3, rb2_4;
    @FXML
    Label labelScore1, labelScore2;

    ArrayList<Question> questions;

    int index = 0;

    public void initialize() {
        questions = DataBase.getQuestionsSubject();
        textFieldSubjectQuestion.setText(DataBase.subjectQuestion.getText());
        group1 = new ToggleGroup();
        group2 = new ToggleGroup();

        setToggleGroup();

        labelPlayer1.setText(DataBase.player1);
        labelPlayer2.setText(DataBase.player2);

        setInfoQuestion();

    }

    public void setToggleGroup() {
        rb1_1.setToggleGroup(group1);
        rb1_2.setToggleGroup(group1);
        rb1_3.setToggleGroup(group1);
        rb1_4.setToggleGroup(group1);

        rb2_1.setToggleGroup(group2);
        rb2_2.setToggleGroup(group2);
        rb2_3.setToggleGroup(group2);
        rb2_4.setToggleGroup(group2);
    }


    public void exit1() throws IOException {
        String[] array = {"بازیکن", "با", "امتیاز برنده شد چون بازیکن", "از بازی خارج شد."};
        String text = String.format("%s %s %S %d %s %s %s", array[0], labelPlayer2.getText()
                , array[1], Integer.parseInt(labelScore2.getText()), array[2], labelPlayer1.getText(), array[3]);
        showMessage(text);
        back();
    }

    public void exit2() throws IOException {
        String[] array = {"بازیکن", "با", "امتیاز برنده شد چون بازیکن", "از بازی خارج شد."};
        String text = String.format("%s %s %S %d %s %s %s", array[0], labelPlayer1.getText()
                , array[1], Integer.parseInt(labelScore1.getText()), array[2], labelPlayer2.getText(), array[3]);
        showMessage(text);
        back();
    }

    public void next1() throws IOException {
        index++;
        labelScore2.setText(Integer.parseInt(labelScore2.getText()) + 1 + "");
        if (index >= questions.size())
            endGame(labelPlayer2.getText(), Integer.parseInt(labelScore2.getText()));
        else
            setInfoQuestion();
    }

    public void next2() throws IOException {
        index++;
        labelScore1.setText(Integer.parseInt(labelScore1.getText()) + 1 + "");
        if (index >= questions.size())
            endGame(labelPlayer1.getText(), Integer.parseInt(labelScore1.getText()));
        else
            setInfoQuestion();
    }

    public void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.getDialogPane().setPrefSize(350, 100);
        alert.setTitle("اطلاع");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void back() throws IOException {
        Stage stage = (Stage) labelPlayer1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start_game_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Game");
        stage.setScene(scene);
    }

    public void setOptions1() {
        rb1_1.setText(DataBase.questions.get(index).getOption1());
        rb1_2.setText(DataBase.questions.get(index).getOption2());
        rb1_3.setText(DataBase.questions.get(index).getOption3());
        rb1_4.setText(DataBase.questions.get(index).getOption4());
    }

    public void setOptions2() {
        rb2_1.setText(DataBase.questions.get(index).getOption1());
        rb2_2.setText(DataBase.questions.get(index).getOption2());
        rb2_3.setText(DataBase.questions.get(index).getOption3());
        rb2_4.setText(DataBase.questions.get(index).getOption4());
    }

    public void setInfoQuestion() {
        labelTextQuestion1.setText(DataBase.questions.get(index).getText());
        labelTextQuestion2.setText(DataBase.questions.get(index).getText());
        setOptions1();
        setOptions2();

    }

    public void endGame(String player, int score) throws IOException {
        String[] array = {"بازیکن", "با", "امتیاز برنده شد."};
        String text = String.format("%s %s %s %d %s", array[0], player
                , array[1], score, array[2]);
        showMessage(text);
        back();
    }

    public void answer1(ActionEvent actionEvent) throws IOException {
        RadioButton btn = (RadioButton) group1.getSelectedToggle();
        if (btn==null)
            return;
        if (btn.getText().equals(questions.get(index).getAnswer())) {
            labelScore1.setText(Integer.parseInt(labelScore1.getText())+1+"");
            index++;
            if (index >= questions.size())
                endQuestion();
            else
                setInfoQuestion();
        }
    }

    public void answer2(ActionEvent actionEvent) throws IOException {
        RadioButton btn = (RadioButton) group2.getSelectedToggle();
        if (btn==null)
            return;
        if (btn.getText().equals(questions.get(index).getAnswer())){
            labelScore2.setText(Integer.parseInt(labelScore2.getText())+1+"");
            index++;
            if (index >= questions.size())
                endQuestion();
            else
                setInfoQuestion();
        }
    }
    public void endQuestion() throws IOException {
        if (Integer.parseInt(labelScore1.getText())>Integer.parseInt(labelScore2.getText()))
            endGame(labelPlayer1.getText(), Integer.parseInt(labelScore1.getText()));
        else if (Integer.parseInt(labelScore1.getText())<Integer.parseInt(labelScore2.getText()))
            endGame(labelPlayer2.getText(), Integer.parseInt(labelScore2.getText()));
        else{
            showMessage("بازی مساوی به اخر رسید.");
            back();
        }
    }
}
