package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SensorEvent;

public interface EventProcessor {
    void handle(SensorEvent event);

}
