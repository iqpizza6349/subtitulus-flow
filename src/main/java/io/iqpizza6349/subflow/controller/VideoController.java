package io.iqpizza6349.subflow.controller;

import io.iqpizza6349.subflow.interaction.EventInteraction;
import io.iqpizza6349.subflow.interaction.file.FileInteraction;
import io.iqpizza6349.subflow.interaction.file.OpenFileInteraction;
import io.iqpizza6349.subflow.util.ThumbnailExtractor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * This controller class is interact with video-editor.fxml
 * <p>
 *     Interacts such as short-cuts for editor.
 *     or do something that show something(like video preview or rewinding)
 * </p>
 *
 * @since 0.1.0
 * @author iqpizza6349
 * @version 0.1.0
 */
public class VideoController {
    private static final Logger log = LogManager.getLogger(VideoController.class);

    @FXML
    private ImageView edVideo1;

    @FXML
    private Button button;

    @FXML
    private Stage stage;

    @FXML
    private void onVideoAddClick(ActionEvent event) {
        if (log.isDebugEnabled()) {
            log.debug("interacted button click");
        }

        FileInteraction interaction = new OpenFileInteraction();
        File file = interaction.openFile(new EventInteraction(event, stage));
        if (file == null) {
            return;
        }

        File thumbnail = ThumbnailExtractor.extractThumbnail(file);
        edVideo1.setImage(new Image(thumbnail.getPath()));
    }
}
