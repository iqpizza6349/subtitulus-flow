package io.iqpizza6349.subflow.window.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

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

    public WindowMenu(String text) {
        super(text);
    }

    public WindowMenu(String text, MenuItem... items) {
        super(text, null, items);
    }

    public WindowMenu(MenuType type) {
        super(type.name().toLowerCase(), null, type.items());
    }

    public WindowMenu addSubItems(MenuItem... items) {
        getItems().addAll(items);
        return this;
    }
}
