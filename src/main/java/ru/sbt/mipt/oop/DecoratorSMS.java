package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class DecoratorSMS implements EventProcessor {

    private SmartHome smartHome;
    private EventProcessor eventProcessor;

    public DecoratorSMS(SmartHome smartHome, EventProcessor eventProcessor) {
        this.smartHome = smartHome;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void handle(SensorEvent event) {

        Alarm alarm = new Alarm();

        if(!isSensorEvent(event)) {
            return;
        }

        if (alarm.getStatus() instanceof AlarmDeactivated){
             return;
        }
        else {
             System.out.println("Sending sms");
            return;
        }

    }

    boolean isSensorEvent(SensorEvent event) {
        return (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED ||
                event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }
}
