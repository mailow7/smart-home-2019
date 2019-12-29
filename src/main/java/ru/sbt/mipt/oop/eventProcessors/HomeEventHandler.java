package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.eventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class HomeEventHandler {

    public static void processHomeEvent(SmartHome smartHome, EventProcessor processor) {
        SensorEvent event = GetSmarthomeEventRandom.getEvent();
        while (event != null) {
            processor.processEvent(smartHome, event);
            event = GetSmarthomeEventRandom.getEvent();
        }
    }

}
