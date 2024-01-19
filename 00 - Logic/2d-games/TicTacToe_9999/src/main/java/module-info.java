module com.example.tictactoe_9999 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tictactoe_9999 to javafx.fxml;
    exports com.example.tictactoe_9999;
}