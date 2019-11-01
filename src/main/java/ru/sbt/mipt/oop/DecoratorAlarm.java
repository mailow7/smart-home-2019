package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmAlert;
import ru.sbt.mipt.oop.Alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DecoratorAlarm implements EventProcessor {
    private SmartHome smartHome;
    private EventProcessor eventProcessor;

    public DecoratorAlarm(SmartHome smartHome, EventProcessor eventProcessor) {
        this.smartHome = smartHome;
        this.eventProcessor = eventProcessor;
    }


    @Override
    public void handle(SensorEvent event) {
        Alarm alarm = smartHome.getAlarm();

        if (alarm.getStatus() instanceof AlarmAlert) {

            return;
        } else if (alarm.getStatus() instanceof AlarmDeactivated) {

            eventProcessor.handle(event);
        } else {

            eventProcessor.handle(event);

            if (isSensorEvent(event)) {

                alarm.Alerting();
            }
        }

    }

    boolean isSensorEvent(SensorEvent event) {
        return (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED ||
                event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }
}
