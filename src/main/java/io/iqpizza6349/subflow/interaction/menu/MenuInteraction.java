package io.iqpizza6349.subflow.interaction.menu;

import io.iqpizza6349.subflow.interaction.EventInteraction;

/**
 * This interface is made because click(interact) on menu item.
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
@FunctionalInterface
public interface MenuInteraction {

    void menuReply(EventInteraction interaction);
}
