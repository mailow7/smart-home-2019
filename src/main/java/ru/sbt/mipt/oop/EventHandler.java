package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensorevents.SensorEvent;

public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}
