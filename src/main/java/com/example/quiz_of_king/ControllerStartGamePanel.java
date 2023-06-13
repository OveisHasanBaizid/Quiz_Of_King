package com.example.quiz_of_king;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerStartGamePanel {
    @FXML
    TextField textFieldPlayer1, textFieldPlayer2;
    @FXML
    ComboBox<String> comboBox;

    public void initialize() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("مذهبی");
        strings.add("ورزشی");
        strings.add("جفرافیا");
        strings.add("هنر");
        strings.add("ریاضی");
        strings.add("زبان");
        strings.add("هوش");
        comboBox.setItems(FXCollections.observableArrayList(strings));
    }

    public void start() throws IOException {
        if (textFieldPlayer1.getText().isEmpty())
            showMessage("نام بازیکن اول وارد نشده است.", "خطا");
        else if (textFieldPlayer2.getText().isEmpty())
            showMessage("نام بازیکن دوم وارد نشده است.", "خطا");
        else if (comboBox.getValue() == null)
            showMessage("موضوع سوالات انتخاب نشده است.", "خطا");
        else {
            DataBase.player1 = textFieldPlayer1.getText();
            DataBase.player2 = textFieldPlayer2.getText();
            DataBase.subjectQuestion = SubjectQuestion.setText(comboBox.getValue());
            if (DataBase.getQuestionsSubject().size() == 0)
                showMessage("برای این موضوع سوالی وجود ندارد.", "خطا");
            else {
                Stage stage = (Stage) textFieldPlayer1.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game_panel.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 500);
                stage.setTitle("Game");
                stage.setScene(scene);
            }
        }
    }

    public void exit() throws IOException {
        Stage stage = (Stage) textFieldPlayer1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 400);
        stage.setTitle("Quiz Of King");
        stage.setScene(scene);
    }

    public void showMessage(String message, String type) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (type.equals("خطا"))
            alert.setAlertType(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.getDialogPane().setPrefSize(300, 100);
        alert.setTitle(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
