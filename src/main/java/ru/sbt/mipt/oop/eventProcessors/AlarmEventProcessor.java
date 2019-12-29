package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.EventHandler;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.sensorevents.AlarmEventType;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.sensorevents.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventHandler {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (event instanceof AlarmEvent) {
            AlarmEvent alarmEvent = (AlarmEvent) event;
                HomeAlarm homeAlarm = smartHome.getHomeAlarm();
            AlarmEventType type = alarmEvent.getType();
            String pin = alarmEvent.getPin();
            if (type == ALARM_ACTIVATE) {
                homeAlarm.activate(pin);
            } else if (type == ALARM_DEACTIVATE) {
                homeAlarm.deactivate(pin);
            }

        }


    }


}
