package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.Alarm.AlarmStatus;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class DecorateAlarmEventProcessor implements EventProcessor {

    private EventProcessor processor;
    private final MessageSender messageSender;

    public DecorateAlarmEventProcessor(EventProcessor processor, MessageSender messageSender) {
        this.processor = processor;
        this.messageSender = messageSender;
    }

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        AlarmStatus status = smartHome.homeAlarm.getStatus();
        messageSender.send("Got event: " + event);

        if (event instanceof AlarmEvent) {
            if (((AlarmEvent) event).getType() == ALARM_DEACTIVATE || status instanceof AlarmDeactivated) {
                processor.handle(smartHome, event);
            } else {
                smartHome.homeAlarm.Alerting(messageSender);
            }
        }
    }

}
