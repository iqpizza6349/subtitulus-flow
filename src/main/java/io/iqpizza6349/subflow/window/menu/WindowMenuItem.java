package io.iqpizza6349.subflow.window.menu;

import io.iqpizza6349.subflow.interaction.EventInteraction;
import io.iqpizza6349.subflow.interaction.menu.MenuInteraction;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class is usually used on window menu
 */
public class WindowMenuItem extends MenuItem {

    public WindowMenuItem(String text) {
        super(text);
    }

    public WindowMenuItem(String text, Stage stage, MenuInteraction interaction) {
        super(text);
        addInteraction(interaction, stage);
    }

    public WindowMenuItem(String text, String image) {
        super(text, new ImageView(image));
    }

    public WindowMenuItem(String text, Image image) {
        super(text, new ImageView(image));
    }

    public WindowMenuItem(String text, Image image, Stage stage, MenuInteraction interaction) {
        super(text, new ImageView(image));
        addInteraction(interaction, stage);
    }

    protected void addInteraction(MenuInteraction interaction, Stage stage) {
        setOnAction(event -> interaction.menuReply(new EventInteraction(event, stage)));
    }
}
