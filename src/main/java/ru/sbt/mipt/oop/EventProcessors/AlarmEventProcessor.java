package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Alarm.HomeAlarm;
import ru.sbt.mipt.oop.Sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.Sensorevents.AlarmEventType;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (event instanceof AlarmEvent) {
            AlarmEvent alarmEvent = (AlarmEvent) event;
                HomeAlarm homeAlarm = smartHome.getHomeAlarm();
            AlarmEventType type = alarmEvent.getType();
            String pin = alarmEvent.getPin();
            if (type == ALARM_ACTIVATE) {
                homeAlarm.Activate(pin);
            } else if (type == ALARM_DEACTIVATE) {
                homeAlarm.Deactivate(pin);
            }

        }


    }


}
