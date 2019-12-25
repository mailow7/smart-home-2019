package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class HomeEventHandler {

    public static void processHomeEvent(SmartHome smartHome, EventProcessor processor) {
        SensorEvent event = GetSmarthomeEventRandom.getEvent();
        while (event != null) {
            processor.handle(smartHome, event);
            event = GetSmarthomeEventRandom.getEvent();
        }
    }

}
