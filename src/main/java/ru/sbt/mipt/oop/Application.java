package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventMaker.GetSmarthomeEventRandom;
import ru.sbt.mipt.oop.EventProcessors.*;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateBuilder;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Messanger.MessageSenderConsole;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateBuilder.getState();
        MessageSender messageSender = new MessageSenderConsole();

        List<EventProcessor> processors = Arrays.asList(

                new DoorEventProcessor(smartHome),
                new LightEventProcessor(smartHome),
                new AlarmEventProcessor(smartHome),
                new HallDoorProcessor(smartHome)

        );

        EventProcessor homeProcessor = new CheckAlarm(smartHome.getHomeAlarm(),
                new HomeProcessor(processors), messageSender);



        getHomeEvents(smartHome, homeProcessor);
    }

    private static void getHomeEvents(SmartHome smartHome, EventProcessor processor) {
        SensorEvent event = GetSmarthomeEventRandom.getEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            processor.handle(event);
            event = GetSmarthomeEventRandom.getEvent();
        }
    }
}
