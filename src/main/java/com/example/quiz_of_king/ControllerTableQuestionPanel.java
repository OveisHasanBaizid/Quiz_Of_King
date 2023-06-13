package com.example.quiz_of_king;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ControllerTableQuestionPanel {
    @FXML
    TableView<Question> tableView;

    @FXML
    TableColumn<Question, String> columnText;
    @FXML
    TableColumn<Question,Question> columnNumber;

    public void initialize() {
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

                        if (this.getTableRow() != null && item != null) {
                            setText(this.getTableRow().getIndex() + "");
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
}
