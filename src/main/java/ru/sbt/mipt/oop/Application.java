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

import static ru.sbt.mipt.oop.EventProcessors.GetHomeProcessor.getHomeProcessor;
import static ru.sbt.mipt.oop.EventProcessors.HomeEventHandler.processHomeEvent;

public class Application {

    public static void main(String[] args) {

        HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateBuilder.getState();
        EventProcessor homeProcessor = getHomeProcessor();
        processHomeEvent(smartHome, homeProcessor);
    }

}
