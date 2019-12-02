package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Alarm.HomeAlarm;
import ru.sbt.mipt.oop.Sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.Sensorevents.AlarmEventType;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

    private final SmartHome smartHome;

    public AlarmEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void handle(SensorEvent event) {
        if (event instanceof AlarmEvent) {
            AlarmEvent alarmEvent = (AlarmEvent) event;
            smartHome.execute(obj -> {
                if (!(obj instanceof HomeAlarm)) return;
                HomeAlarm homeAlarm = (HomeAlarm) obj;
                AlarmEventType type = alarmEvent.getType();
                String pin = alarmEvent.getPin();
                if (type == ALARM_ACTIVATE) {
                    homeAlarm.alarmActivated(pin);
                } else if (type == ALARM_DEACTIVATE) {
                    homeAlarm.alarmDeactivated(pin);
                }
            });
        }


    }


}
