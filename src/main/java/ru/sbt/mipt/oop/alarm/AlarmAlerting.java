package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.messanger.MessageSender;

public class AlarmAlerting implements AlarmStatus {
    private final String pin;
    private final HomeAlarm homeAlarm;

    public AlarmAlerting(HomeAlarm homeAlarm, String pin) {
        this.homeAlarm = homeAlarm;
        this.pin = pin;
    }

    @Override
    public void alarmActivated(String alarmPin) {

    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        if (pin.equals(alarmPin)) {
            homeAlarm.setStatus(new AlarmDeactivated(homeAlarm, pin));
        }

    }

    @Override
    public void alarmAlerting(MessageSender messageSender) {
    }
}
