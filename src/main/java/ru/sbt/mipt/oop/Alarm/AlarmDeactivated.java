package ru.sbt.mipt.oop.Alarm;

public class AlarmDeactivated extends HomeAlarmStatus {

    private final String pin;

    public AlarmDeactivated(HomeAlarm homeAlarm, String pin) {
        this.pin = pin;
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void alarmActivated(String pin) {

        homeAlarm.setStatus(new AlarmActivated(homeAlarm,pin));

    }

    @Override
    public void alarmDeactivated(String alarmPin) {

    }

    @Override
    public void alarmAlerting() {
        homeAlarm.setStatus(new AlarmAlerting(homeAlarm,pin));

    }

}
