package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.EventHandler;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import java.util.Collection;

public class HomeProcessor implements EventProcessor {
    private Collection<EventHandler> processors;

    public HomeProcessor(Collection<EventHandler> processors) {
        this.processors = processors;
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        for (EventHandler processor : processors) {
            processor.handle(smartHome, event);
        }
    }
}