package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.EventProcessors.AlarmEventProcessor;

public class AlarmDeactivated implements AlarmStatus {

    private final String pin;
    private final HomeAlarm homeAlarm;

    public AlarmDeactivated(HomeAlarm homeAlarm, String pin) {
        this.pin = pin;
        this.homeAlarm = homeAlarm;
    }

    @Override
    public void alarmActivated(String pin) {

        homeAlarm.setStatus(new AlarmActivated(
                pin, homeAlarm));

    }

    @Override
    public void alarmDeactivated(String alarmPin) {

    }

    @Override
    public void alarmAlerting() {
        homeAlarm.setStatus(new AlarmAlerting(homeAlarm,pin));

    }

}
