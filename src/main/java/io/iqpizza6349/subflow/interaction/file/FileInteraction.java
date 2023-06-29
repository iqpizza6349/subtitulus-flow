package io.iqpizza6349.subflow.interaction.file;

import io.iqpizza6349.subflow.interaction.EventInteraction;

/**
 * This interface is made because open file or directory, or save file.
 * This is not function interface, do not recommend to use like a function
 * interface.
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public interface FileInteraction {

    void openFile(EventInteraction interaction);

}
