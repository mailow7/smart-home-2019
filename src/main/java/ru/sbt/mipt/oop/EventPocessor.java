package ru.sbt.mipt.oop;

public class EventPocessor {
    public void processEvent(SmartHome smartHome, SensorEvent event){
        System.out.println("Get event: " + event);

        new LightEventProcessor().handle(smartHome, event);
        new DoorEventProcessor().handle(smartHome, event);
        new HallEventProcessor().handle(smartHome, event);

    }

}
