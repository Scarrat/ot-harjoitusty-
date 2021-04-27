module dungeongame {
    requires javafx.fxml;
    requires javafx.controls;
    opens dungeongame to javafx.graphics;
    exports dungeongame;
}
