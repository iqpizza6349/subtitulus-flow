package io.iqpizza6349.subflow.interaction.file;

import io.iqpizza6349.subflow.interaction.EventInteraction;import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * This interaction class is implements the fileInteraction interface to
 * reply a file opener(show a file chooser)
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public class OpenFileInteraction implements FileInteraction {
    public static final Logger log = LogManager.getLogger(OpenFileInteraction.class);

    @Override
    public void openFile(EventInteraction interaction) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("그림 파일: Image Files", "*.png", "*.jpg"),
                new ExtensionFilter("음악 파일: Audio Files", "*.wav", "*.mp3", "*.aac", "*.ogg"),
                new ExtensionFilter("동영상 파일: Video Files", "*.mp4", "*.mpv", "*.mkv")
        );

        File file = fileChooser.showOpenDialog(interaction.getStage());
        if (file != null) {
            log.info("this is file path: {} that you choose", file.getPath());
        }
        else {
            log.warn("You did not choose anything");
        }
    }
}
