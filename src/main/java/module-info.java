module io.iqpizza6349.subflow {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;

    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires jcodec;
    requires java.desktop;

    requires org.reflections;

    opens io.iqpizza6349.subflow.controller to javafx.fxml;
    opens io.iqpizza6349.subflow to jcodec, org.reflections;
    exports io.iqpizza6349.subflow;
}