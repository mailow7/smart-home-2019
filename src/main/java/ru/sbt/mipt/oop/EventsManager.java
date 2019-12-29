package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventProcessors.EventProcessor;

import java.util.List;

public class EventsManager implements HomeEventsManager {

    private List<EventProcessor> eventProcessors;

    public EventsManager(List<EventProcessor> eventProcessors) {
        this.eventProcessors = eventProcessors;
    }


    @Override
    public void start() {
        //GetSmarthomeEvent eventSmarthome = new GetSmarthomeEventRandom();
        //SensorEvent event = eventSmarthome.getEvent();

//        while (event != null) {
//            System.out.println("Got event: " + event);
//
//            for (EventProcessor oneProcessor : eventProcessors) {
//                oneProcessor.handle(event);
//            }
//
//            event = eventSmarthome.getEvent();
//        }
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

}
