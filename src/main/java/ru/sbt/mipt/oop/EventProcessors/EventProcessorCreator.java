package ru.sbt.mipt.oop.EventProcessors;

import java.util.ArrayList;
import java.util.Collection;

public class EventProcessorCreator {
    public static Collection<EventProcessor> getNewEventProcessor() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();

        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new LightEventProcessor());
        eventProcessors.add(new HallDoorProcessor());

        return eventProcessors;


    }
}