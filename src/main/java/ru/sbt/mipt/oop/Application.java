package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.HomeBuilders.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.HomeBuilders.HomeStateBuilder;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.EventProcessors.GetHomeProcessor.getHomeProcessor;
import static ru.sbt.mipt.oop.EventProcessors.HomeEventHandler.processHomeEvent;

public class Application {

    public static void main(String[] args) {

        HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateBuilder.getState();
        EventProcessor homeProcessor = getHomeProcessor();
        processHomeEvent(smartHome, homeProcessor);

//        HomeState homeState = new getSmarthomefromJSON();
//        SmartHome smartHome = homeState.GetState();
//        getHomeEvents(smartHome);
    }

//    private static void getHomeEvents(SmartHome smartHome) {
//        GetSmarthomeEventRandom eventrandom = new GetSmarthomeEventRandom();
//        SensorEvent event = eventrandom.getEvent();
//
//        Collection<EventProcessor> eventProcessors = EventProcessorDecorator.getNewEventProcessors(smartHome);
//
//        while (event != null) {
//            System.out.println("Got event: " + event);
//
//            EventProcessor eventProcessor = EventProcessorChecker.getNewEventChecker(smartHome, event);
//            eventProcessor.handle(event);
//
//            event = eventrandom.getEvent();
//        }
//    }
}
