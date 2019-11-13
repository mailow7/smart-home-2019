package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

public class DecoratorSMS implements EventProcessor {

    private SmartHome smartHome;
    private EventProcessor eventProcessor;

    public DecoratorSMS(SmartHome smartHome, EventProcessor eventProcessor) {
        this.smartHome = smartHome;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void handle(SensorEvent event) {

        Alarm alarm = smartHome.getAlarm();

        if (alarm.getStatus() instanceof AlarmDeactivated || event instanceof SensorEvent) {
            return;
        } else {
            System.out.println("Sending sms");
            return;
        }

    }

}
