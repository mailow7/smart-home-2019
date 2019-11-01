package ru.sbt.mipt.oop.Alarm;

public class AlarmActivated implements AlarmStatus {

    private Alarm alarm;

    public AlarmActivated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void alarmActivated(String alarmPin) {
        System.out.println("Alarm active!");
    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        if (alarm.validateCode(alarmPin)) {

            AlarmStatus newStatus = new AlarmDeactivated(alarm);
            alarm.setStatus(newStatus);
            System.out.println("Alarm deactivated");

        } else {

            System.out.println("Wrong password entered!");
            AlarmStatus newStatus = new AlarmAlert(alarm);
            alarm.setStatus(newStatus);
            alarm.Alerting();
        }
    }

    @Override
    public void alarmAlerting() {

    }

}
