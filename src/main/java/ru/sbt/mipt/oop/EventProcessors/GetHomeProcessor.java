package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.DecoratorEvent;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Arrays;
import java.util.List;

public class GetHomeProcessor {

    public static EventProcessor getHomeProcessor() {
        List<EventProcessor> processors = Arrays.asList(
                new DoorEventProcessor(),
                new LightEventProcessor(),
                new AlarmEventProcessor(),
                new HallDoorProcessor()
        );
        return new DecoratorEvent(new HomeProcessor(processors));
    }

}
