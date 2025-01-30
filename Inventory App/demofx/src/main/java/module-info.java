module xxx.yyy {
    requires javafx.controls;
    requires javafx.fxml;

    opens xxx.yyy to javafx.fxml;
    exports xxx.yyy;
}
