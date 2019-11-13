package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessorChecker;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateBuilder;

public class Application {

    public static void main(String[] args) {

        HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateBuilder.getState();
        getHomeEvents(smartHome);
    }

    private static void getHomeEvents(SmartHome smartHome) {
        GetSmarthomeEventRandom eventrandom = new GetSmarthomeEventRandom();
        SensorEvent event = eventrandom.getEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            EventProcessor eventProcessor = EventProcessorChecker.getNewEventChecker(smartHome, event);
            eventProcessor.handle(event);
            event = eventrandom.getEvent();
        }
    }
}
