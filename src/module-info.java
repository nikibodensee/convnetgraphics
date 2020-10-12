module convnetgraphics {

    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires com.jfoenix;
    requires kotlin.stdlib;

    exports main.java.UI;
    opens main.java.UI to javafx.graphics, javafx.fxml, javafx.controls;

}