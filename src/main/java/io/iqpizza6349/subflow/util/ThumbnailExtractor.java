package io.iqpizza6349.subflow.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This Util class is extract thumbnail from video files(such as mp4)
 *
 * @since 0.1.0
 * @author iqpizza6349
 */
public class ThumbnailExtractor {
    private static final Logger log = LogManager.getLogger(ThumbnailExtractor.class);

    private static final File TMP = new File(System.getProperty("user.dir") + "/tmp/");

    public static File extractThumbnail(File source) {
        if (!TMP.exists()) {
            if (TMP.mkdir()) {
                if (log.isDebugEnabled()) {
                    log.debug("Created tmp directory for temporary save thumbnails");
                }
            } else {
                log.warn("Failed to create tmp directory");
            }
        }

        // TODO: change name with specific name
        File thumbnail = new File(TMP, String.format(source.getName() + "_thumbnail.png"));
        return extractThumbnail(source, thumbnail);
    }

    public static File extractThumbnail(File source, File thumbnail) {
        assert source != null : "Source cannot be null";
        assert thumbnail != null : "Thumbnail cannot be null";

        if (log.isDebugEnabled()) {
            log.debug("Extracting thumbnail from video");
        }

        int frameNumber = 0;
        try {
            Picture picture = FrameGrab.getFrameFromFile(source, frameNumber);
            BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
            ImageIO.write(bufferedImage, "png", thumbnail);
        } catch (IOException | JCodecException e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getLocalizedMessage());
            }

            log.error("Error occurs when extract thumbnail from video file.", e);
        }

        if (log.isDebugEnabled()) {
            log.debug(thumbnail);
        }

        return thumbnail;
    }
}
