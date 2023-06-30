package io.iqpizza6349.subflow.window.menu;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * This enum class defines all types for used on window menu class
 * @see WindowMenu
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public enum MenuType {
    FILE {
        @Override
        public MenuItem[] items(Stage stage) {
            return new MenuItem[]{
                    new WindowMenuItem("New"),
                    new WindowMenuItem("Open (Ctrl + O)"),
                    new WindowMenuItem("Save (Ctrl + S)"),
                    new WindowMenu("Export", stage).addSubItems(
                            new WindowMenuItem("mp4"),
                            new WindowMenuItem("mov")
                    ),
                    new WindowMenuItem("Exit", stage, interaction -> {
                        stage.setOnCloseRequest(event -> Platform.exit());
                        System.exit(0);
                    })
            };
        }
    },
    EDIT {
        @Override
        public MenuItem[] items(Stage stage) {
            return new MenuItem[]{
                    new WindowMenuItem("Undo (Ctrl + Z)"),
                    new WindowMenuItem("Redo (Ctrl + Y)"),
                    new WindowMenuItem("Cut (Ctrl + X)"),
                    new WindowMenuItem("Copy (Ctrl + C)"),
                    new WindowMenuItem("Paste (Ctrl + V)"),
                    new WindowMenuItem("Delete (delete)"),
                    new WindowMenu("Find", stage).addSubItems(
                            new WindowMenuItem("Find (Ctrl + F)"),
                            new WindowMenuItem("Replace (Ctrl + R)")
                    ),
                    new WindowMenu("Bookmark", stage).addSubItems(
                            new WindowMenuItem("Add Bookmark (Ctrl + F11)"),
                            new WindowMenuItem("Toggle Bookmark (F11)")
                    ),
                    new WindowMenuItem("New Component (Alt + Insert)")
            };
        }
    },
    RUN {
        @Override
        public MenuItem[] items(Stage stage) {
            return new MenuItem[]{
                    new WindowMenuItem("Run (Ctrl + F10)"),
                    new WindowMenuItem("Pause (F10)"),
                    new WindowMenuItem("Stop (Ctrl + F2)")
            };
        }
    },
    HELP {
        @Override
        public MenuItem[] items(Stage stage) {
            return new MenuItem[]{
                    new WindowMenuItem("Help (F1)")
            };
        }
    };

    public abstract MenuItem[] items(Stage stage);
}
