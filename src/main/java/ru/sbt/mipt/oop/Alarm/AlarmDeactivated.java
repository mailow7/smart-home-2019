package ru.sbt.mipt.oop.Alarm;

public class AlarmDeactivated implements AlarmStatus {

    private Alarm alarm;

    public AlarmDeactivated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void alarmActivated(String alarmPin) {

        alarm.setPin(alarmPin);

        AlarmStatus newStatus = new AlarmActivated(alarm);
        alarm.setStatus(newStatus);
        System.out.println("Alarm activated");
    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        System.out.println("Alarm deactivated");
    }

    @Override
    public void alarmAlerting() {
        AlarmStatus newStatus = new AlarmAlert(alarm);
        alarm.setStatus(newStatus);
        alarm.Alerting();
    }

}
