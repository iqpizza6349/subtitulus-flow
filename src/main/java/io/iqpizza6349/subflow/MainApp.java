package io.iqpizza6349.subflow;

import io.iqpizza6349.subflow.window.menu.MenuType;
import io.iqpizza6349.subflow.window.menu.WindowMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SubtitulusFlow");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("controller/video-editor.fxml"));

        // Create the root layout (e.g., StackPane)
        AnchorPane root = new AnchorPane();

        BorderPane menuPane = new BorderPane();

        // Add menu, and menu items to the menubar
        Menu fileMenu = new WindowMenu(MenuType.FILE, primaryStage);
        Menu editMenu = new WindowMenu(MenuType.EDIT, primaryStage);
        Menu runMenu = new WindowMenu(MenuType.RUN, primaryStage);
        Menu helpMenu = new WindowMenu(MenuType.HELP, primaryStage);

        MenuBar menuBar = new MenuBar(fileMenu, editMenu, runMenu, helpMenu);
        VBox vBox = new VBox(menuBar);
        menuPane.setTop(vBox);

        StackPane videoPane = new StackPane();
        videoPane.setStyle("-fx-background-color: #303030");

        // Add components or content to the layout
        videoPane.getChildren().add(loader.load());
        menuPane.setLeft(videoPane);

        // Add panes to the root layout
        root.getChildren().addAll(menuPane);

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
