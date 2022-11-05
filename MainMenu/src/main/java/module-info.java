module com.example.mainmenu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mainmenu to javafx.fxml;
    exports com.example.mainmenu;
}