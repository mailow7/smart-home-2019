package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventProcessorChecker {
    public static EventProcessor getNewEventChecker(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            LightEventProcessor lightProcessor = new LightEventProcessor(smartHome);
            return lightProcessor;
        }
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            DoorEventProcessor doorProcessor = new DoorEventProcessor(smartHome);
            return doorProcessor;
        } else {
            return null;
        }
    }
}