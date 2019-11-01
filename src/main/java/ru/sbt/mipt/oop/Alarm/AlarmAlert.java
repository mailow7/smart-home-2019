package ru.sbt.mipt.oop.Alarm;

public class AlarmAlert implements AlarmStatus {

    private Alarm alarm;

    public AlarmAlert(Alarm alarm) {

        this.alarm = alarm;

    }

    @Override
    public void alarmActivated(String alarmPin) {
        System.out.println("Alarm active! Alerting!");
    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        if (alarm.validateCode(alarmPin)) {

            AlarmStatus newStatus = new AlarmDeactivated(alarm);
            alarm.setStatus(newStatus);
            System.out.println("Alarm deactivated");
        } else {
            System.out.println("Wrong password! Alerting!");

            AlarmStatus newStatus = new AlarmAlert(alarm);
            alarm.setStatus(newStatus);
            alarm.Alerting();
        }
    }

    @Override
    public void alarmAlerting() {
        System.out.println("Ahtung!");
    }

}
