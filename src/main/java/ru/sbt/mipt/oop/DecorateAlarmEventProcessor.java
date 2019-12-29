package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.alarm.AlarmStatus;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.messanger.MessageSender;
import ru.sbt.mipt.oop.sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class DecorateAlarmEventProcessor implements EventProcessor {

    private EventProcessor processor;
    private final MessageSender messageSender;

    public DecorateAlarmEventProcessor(EventProcessor processor, MessageSender messageSender) {
        this.processor = processor;
        this.messageSender = messageSender;
    }


    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        AlarmStatus status = smartHome.homeAlarm.getStatus();
        messageSender.send("Got event: " + event);

        if (event instanceof AlarmEvent) {
            if (((AlarmEvent) event).getType() == ALARM_DEACTIVATE || status instanceof AlarmDeactivated) {
                processor.processEvent(smartHome, event);
            } else {
                smartHome.homeAlarm.alerting(messageSender);
            }
        }
    }

}
