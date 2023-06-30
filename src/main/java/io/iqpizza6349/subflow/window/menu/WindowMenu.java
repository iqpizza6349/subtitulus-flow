package io.iqpizza6349.subflow.window.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * This class is defines menu and menu item wrapper class that
 * more easy to used in main application
 * <p>
 *     It shows by menubar that lied on label or pane
 * </p>
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public class WindowMenu extends Menu {

    private final Stage stage;

    public WindowMenu(String text, Stage stage) {
        super(text);
        this.stage = stage;
    }

    public WindowMenu(String text, Stage stage, MenuItem... items) {
        super(text, null, items);
        this.stage = stage;
    }

    public WindowMenu(MenuType type, Stage stage) {
        super(type.name().toLowerCase(), null, type.items(stage));
        this.stage = stage;
    }

    public WindowMenu addSubItems(MenuItem... items) {
        getItems().addAll(items);
        return this;
    }

    public Stage getStage() {
        return stage;
    }
}
