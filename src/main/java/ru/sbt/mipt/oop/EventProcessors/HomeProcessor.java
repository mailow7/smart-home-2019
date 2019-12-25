package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class HomeProcessor implements EventProcessor {
    List<EventProcessor> processors;

    public HomeProcessor(List<EventProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        for (EventProcessor processor : processors) {
            processor.handle(smartHome, event);
        }
    }
}