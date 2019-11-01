package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessorChecker;
import ru.sbt.mipt.oop.EventProcessorDecorator;
import ru.sbt.mipt.oop.HomeBuilder.HomeState;
import ru.sbt.mipt.oop.HomeBuilder.getSmarthomefromJSON;

import java.util.Collection;

public class Application {

    public static void main(String[] args) {

        HomeState homeState = new getSmarthomefromJSON();
        SmartHome smartHome = homeState.GetState();
        getHomeEvents(smartHome);
    }

    private static void getHomeEvents(SmartHome smartHome) {
        GetSmarthomeEventRandom eventrandom = new GetSmarthomeEventRandom();
        SensorEvent event = eventrandom.getEvent();

        Collection<EventProcessor> eventProcessors = EventProcessorDecorator.getNewEventProcessors(smartHome);

        while (event != null) {
            System.out.println("Got event: " + event);

            EventProcessor eventProcessor = EventProcessorChecker.getNewEventChecker(smartHome, event);
            eventProcessor.handle(event);

            event = eventrandom.getEvent();
        }
    }
}
