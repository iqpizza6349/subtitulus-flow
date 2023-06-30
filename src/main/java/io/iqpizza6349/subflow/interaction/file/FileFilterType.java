package io.iqpizza6349.subflow.interaction.file;

/**
 * This enum class is define extension file filters
 *
 * @since 0.1.0
 */
public enum FileFilterType {
    IMAGE {
        @Override
        String description() {
            return "그림 파일: Image Files";
        }

        @Override
        String[] extensions() {
            return new String[]{ "*.png", "*.jpg" };
        }
    },
    AUDIO {
        @Override
        String description() {
            return "음악 파일: Audio Files";
        }

        @Override
        String[] extensions() {
            return new String[]{ "*.wav", "*.mp3", "*.aac", "*.ogg" };
        }
    },
    VIDEO {
        @Override
        String description() {
            return "동영상 파일: Video Files";
        }

        @Override
        String[] extensions() {
            return new String[]{ "*.mp4", "*.mpv", "*.mkv" };
        }
    };

    abstract String description();
    abstract String[] extensions();

}
