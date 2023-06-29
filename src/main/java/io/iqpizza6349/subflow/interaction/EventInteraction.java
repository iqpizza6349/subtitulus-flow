package io.iqpizza6349.subflow.interaction;

import javafx.event.Event;
import javafx.stage.Stage;

public final class EventInteraction {

    private final Event event;
    private final Stage stage;

    public EventInteraction(Event event, Stage stage) {
        this.event = event;
        this.stage = stage;
    }

    public Event getEvent() {
        return event;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return "EventInteraction{" + "event=" + event +
                ", stage=" + stage +
                '}';
    }
}
