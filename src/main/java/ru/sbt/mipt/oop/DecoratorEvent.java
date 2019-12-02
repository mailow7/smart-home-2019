package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.*;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

public class DecoratorEvent implements EventProcessor {
    private final EventProcessor eventProcessor;
    private final MessageSender messageSender;
    private final HomeAlarm homeAlarm;

    public DecoratorEvent(HomeAlarm homeAlarm, EventProcessor eventProcessor, MessageSender messageSender) {
        this.eventProcessor = eventProcessor;
        this.messageSender = messageSender;
        this.homeAlarm = homeAlarm;

    }

    @Override
    public void handle(SensorEvent event) {
        AlarmStatus status = homeAlarm.getStatus();

        if (status instanceof AlarmDeactivated) {
            eventProcessor.handle(event);
        }
        if (status instanceof AlarmActivated) {
            homeAlarm.alarmAlerting();
        }
        if (status instanceof AlarmActivated || status instanceof AlarmAlerting) {
            messageSender.send("Sending sms");
        }

    }

}
