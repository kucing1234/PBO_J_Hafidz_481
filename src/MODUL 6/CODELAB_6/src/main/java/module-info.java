module com.example.codelab_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codelab_6 to javafx.fxml;
    exports com.example.codelab_6;
}