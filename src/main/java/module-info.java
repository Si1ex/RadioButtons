module com.example.radiobuttons {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.radiobuttons to javafx.fxml;
    exports com.example.radiobuttons;
}