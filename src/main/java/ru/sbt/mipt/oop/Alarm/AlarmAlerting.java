package ru.sbt.mipt.oop.Alarm;

public class AlarmAlerting extends HomeAlarmStatus {
    private final String pin;

    public AlarmAlerting(HomeAlarm homeAlarm, String pin) {
        this.homeAlarm = homeAlarm;
        this.pin = pin;
    }

    @Override
    public void alarmActivated(String alarmPin) {

    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        if(pin.equals(this.pin)){
            homeAlarm.setStatus(new AlarmDeactivated(homeAlarm, pin));
        }

    }

    @Override
    public void alarmAlerting() {

    }
}
