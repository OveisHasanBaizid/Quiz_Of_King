package com.example.quiz_of_king;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ControllerTableQuestionPanel {
    @FXML
    Label title;
    @FXML
    TableView<Question> tableView;
    @FXML
    TableColumn<Question, String> columnText;
    @FXML
    TableColumn<Question, Question> columnNumber;

    public void initialize() {
        title.setText(DataBase.subjectQuestion.getText());
        setToTable();
    }

    public void setToTable() {
        columnText.setCellValueFactory(new PropertyValueFactory<>("text"));
        columnNumber.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Question, Question> call(TableColumn<Question, Question> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Question item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty) {
                            setText(this.getTableRow().getIndex() + 1 + "");
                        } else {
                            setText("");
                        }
                    }
                };
            }
        });
        columnNumber.setSortable(false);

        ObservableList<Question> data = FXCollections.observableArrayList(DataBase.getQuestionsSubject());
        tableView.setItems(data);
    }

    public void addQuestion() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add_question_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 535, 400);
        stage.setTitle("Quiz Of King");
        stage.setScene(scene);
        stage.showAndWait();
        new Thread(() -> {
            while (stage.isShowing()) ;
            setToTable();
        }).start();
    }
}
