package io.iqpizza6349.subflow.window.menu;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is usually used on window menu
 */
public class WindowMenuItem extends MenuItem {

    public WindowMenuItem(String text) {
        super(text);
    }

    public WindowMenuItem(String text, String image) {
        super(text, new ImageView(image));
    }

    public WindowMenuItem(String text, Image image) {
        super(text, new ImageView(image));
    }
}
