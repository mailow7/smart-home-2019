package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {
    void handle(SmartHome smartHome, SensorEvent event);

}
