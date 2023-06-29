module io.iqpizza6349.subflow {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    opens io.iqpizza6349.subflow.controller to javafx.fxml;
    exports io.iqpizza6349.subflow;
}