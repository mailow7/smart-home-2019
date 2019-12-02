package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

import java.util.List;

public class HomeProcessor implements EventProcessor {

    private final List<EventProcessor> processors;

    public HomeProcessor(List<EventProcessor> processors) {
        this.processors = processors;
    }


    @Override
    public void handle(SensorEvent event) {
        for (EventProcessor processor : processors) {
            processor.handle(event);
        }
    }
}