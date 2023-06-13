package com.example.quiz_of_king;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerAddQuestionPanel {
    @FXML
    TextArea textAreaText;
    @FXML
    TextField textFieldOption1 , textFieldOption2 , textFieldOption3 , textFieldOption4;
    @FXML
    RadioButton rb1 , rb2 , rb3 , rb4;

    ToggleGroup group = new ToggleGroup();

    public void initialize(){

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);

    }
    public void save() throws IOException {
        if (textAreaText.getText().isEmpty())
            showMessage("متن سوال نمیتواند خالی باشد.","خطا");
        else if (textFieldOption1.getText().isEmpty() || textFieldOption2.getText().isEmpty()
                || textFieldOption3.getText().isEmpty() || textFieldOption4.getText().isEmpty())
            showMessage("گزینه های سوال نمیتوانند خالی باشند.","خطا");
        else if (group.getSelectedToggle()==null)
            showMessage("گزینه درست انتخاب نشده است.","خطا");
        else{
            RadioButton radioButton = (RadioButton)group.getSelectedToggle();

            Question question = new Question(textAreaText.getText(),DataBase.subjectQuestion
                    ,radioButton.getText(),textFieldOption1.getText(),textFieldOption2.getText(),
                    textFieldOption3.getText(),textFieldOption4.getText());
            DataBase.addQuestion(question);
            exit();
            showMessage("سوال با موفقیت اضافه شد.","اطلاعات");
        }
    }
    public void exit(){
        Stage stage = (Stage) textAreaText.getScene().getWindow();
        stage.close();
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
