package io.iqpizza6349.subflow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SubtitulusFlow");

        // Create the root layout (e.g., StackPane)
        StackPane root = new StackPane();

        // Add components or content to the layout
        Label label = new Label("Hello, JavaFX!");
        root.getChildren().add(label);

        // Create the scene with layout
        Scene scene = new Scene(root, 1024, 768);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Display the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
