package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.AlarmEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightEventProcessor;

import java.util.ArrayList;
import java.util.Collection;

public class EventProcessorDecorator {

    public static Collection<EventProcessor> getNewEventProcessors(SmartHome smartHome) {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();

        eventProcessors.add(new AlarmEventProcessor(smartHome));

        eventProcessors.add(new DecoratorAlarm(smartHome, new DoorEventProcessor(smartHome)));
        eventProcessors.add(new DecoratorAlarm(smartHome, new LightEventProcessor(smartHome)));

        eventProcessors.add(new DecoratorSMS(smartHome, new DoorEventProcessor(smartHome)));
        eventProcessors.add(new DecoratorSMS(smartHome, new LightEventProcessor(smartHome)));
        return eventProcessors;
    }
}
