package io.iqpizza6349.subflow;

import io.iqpizza6349.subflow.window.menu.MenuType;
import io.iqpizza6349.subflow.window.menu.WindowMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SubtitulusFlow");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("controller/video-editor.fxml"));

        // Create the root layout (e.g., StackPane)
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #303030");

        // Add menu, and menu items to the menubar
        Menu fileMenu = new WindowMenu(MenuType.FILE);
        Menu editMenu = new WindowMenu(MenuType.EDIT);
        Menu runMenu = new WindowMenu(MenuType.RUN);
        Menu helpMenu = new WindowMenu(MenuType.HELP);

        MenuBar menuBar = new MenuBar(fileMenu, editMenu, runMenu, helpMenu);
        VBox vBox = new VBox(menuBar);
        root.getChildren().add(vBox);

        // Add components or content to the layout
        root.getChildren().add(loader.load());

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
