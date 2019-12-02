package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

public interface EventProcessor {
    void handle(SensorEvent event);

}
