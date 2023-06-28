module io.iqpizza6349.subflow {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;

    opens io.iqpizza6349.subflow to javafx.fxml;
    exports io.iqpizza6349.subflow;
}