module com.example.quiz_of_king {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.quiz_of_king to javafx.fxml;
    exports com.example.quiz_of_king;
}