package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.DecorateAlarmEventProcessor;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Messanger.MessageSenderConsole;

import java.util.Arrays;
import java.util.List;

public class GetHomeProcessor {

    public static EventProcessor getHomeProcessor() {
        MessageSender messageSender = new MessageSenderConsole();
        List<EventProcessor> processors = Arrays.asList(
                new DoorEventProcessor(),
                new LightEventProcessor(),
                new AlarmEventProcessor(),
                new HallDoorProcessor()
        );
        return new DecorateAlarmEventProcessor(new HomeProcessor(processors), messageSender);
    }

}
