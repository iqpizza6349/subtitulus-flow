module io.iqpizza6349.subflow {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;

    opens io.iqpizza6349.subflow.controller to javafx.fxml;
    exports io.iqpizza6349.subflow;
}