package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessorCreator;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateBuilder;

import java.util.Collection;

public class Application {

    public static void main(String[] args) {

        HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateBuilder.getState();
        getHomeEvents(smartHome);
    }

    private static void getHomeEvents(SmartHome smartHome) {

        SensorEvent event = GetSmarthomeEventRandom.getEvent();
        Collection<EventProcessor> eventProcessors = EventProcessorCreator.getNewEventProcessor();

        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor : eventProcessors)
                processor.handle(smartHome, event);

            event = GetSmarthomeEventRandom.getEvent();
        }
    }
}
