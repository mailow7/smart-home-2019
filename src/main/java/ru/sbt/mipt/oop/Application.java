package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessorChecker;
import ru.sbt.mipt.oop.HomeBuilder.HomeState;
import ru.sbt.mipt.oop.HomeBuilder.getSmarthomefromJSON;

public class Application {

    public static void main(String[] args) {

        HomeState homeState = new getSmarthomefromJSON();
        SmartHome smartHome = homeState.GetState();
        getHomeEvents(smartHome);
    }

    private static void getHomeEvents(SmartHome smartHome) {

        SensorEvent event = GetSmarthomeEventRandom.GetEvent();

        while (event != null) {
            System.out.println("Got event: " + event);

            EventProcessor eventProcessor = EventProcessorChecker.getNewEventChecker(smartHome, event);
            eventProcessor.handle(smartHome, event);

            event = GetSmarthomeEventRandom.GetEvent();
        }
    }
}
