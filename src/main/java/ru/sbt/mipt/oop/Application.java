package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessorCreator;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateReader;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;

import java.util.Collection;

public class Application {

    public static void main(String[] args) {

        HomeStateReader homeStateReader = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateReader.getState();
        getHomeEvents(smartHome);
    }

    private static void getHomeEvents(SmartHome smartHome) {

        SensorEvent event = GetSmarthomeEventRandom.GetEvent();

        Collection<EventProcessor> eventProcessors = EventProcessorCreator.getNewEventProcessor();

        while (event != null) {
            System.out.println("Got event: " + event);

            for(EventProcessor processor : eventProcessors)
            processor.handle(smartHome, event);

            event = GetSmarthomeEventRandom.GetEvent();
        }
    }
}
