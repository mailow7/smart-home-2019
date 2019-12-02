package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Alarm.*;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

public class CheckAlarm implements EventProcessor {

    private final HomeAlarm homeAlarm;
    private final EventProcessor eventProcessor;
    private final MessageSender messageSender;

    public CheckAlarm(HomeAlarm homeAlarm, EventProcessor eventProcessor, MessageSender messageSender) {
        this.homeAlarm = homeAlarm;
        this.eventProcessor = eventProcessor;
        this.messageSender = messageSender;
    }

    @Override
    public void handle(SensorEvent event) {
        AlarmStatus status = homeAlarm.getStatus();

        if (isAlarmEvent(event)) {
            AlarmEvent alarmSensorEvent = (AlarmEvent) event;

            if (status instanceof AlarmDeactivated) {
                eventProcessor.handle(event);
            }
            if (status instanceof AlarmActivated) {
                homeAlarm.alarmAlerting();
            }
            if (status instanceof AlarmActivated || status instanceof AlarmAlerting) {
                messageSender.send("Alarm!!! Event (" + event.toString() + ")");
            }

        }


    }

    public boolean isAlarmEvent(SensorEvent event) {
        return event instanceof AlarmEvent;
    }


}
