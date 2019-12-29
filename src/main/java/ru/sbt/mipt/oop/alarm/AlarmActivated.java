package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.messanger.MessageSender;

public class AlarmActivated implements AlarmStatus {
    private final String pin;
    private final HomeAlarm homeAlarm;

    public AlarmActivated(String pin, HomeAlarm homeAlarm) {
        this.pin = pin;
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void alarmActivated(String alarmPin) {
    }

    @Override
    public void alarmDeactivated(String pin) {
        if (pin.equals(this.pin)) {
            homeAlarm.setStatus(new AlarmDeactivated(homeAlarm, pin));
        } else {
            homeAlarm.setStatus(new AlarmAlerting(homeAlarm, this.pin));
        }
    }

    @Override
    public void alarmAlerting(MessageSender messageSender) {
        homeAlarm.setStatus(new AlarmAlerting(homeAlarm, this.pin));
    }

}
