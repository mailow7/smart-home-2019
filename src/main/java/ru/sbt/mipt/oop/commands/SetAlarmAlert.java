package ru.sbt.mipt.oop.commands;


import ru.sbt.mipt.oop.SmartHome;

public class SetAlarmAlert implements Command {

    private SmartHome smartHome;

    public SetAlarmAlert(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
//        Alarm alarm = smartHome.getAlarm();
//        AlarmStatus alarmStatus = new AlarmAlert(alarm);
//        alarm.setStatus(alarmStatus);
//        alarm.Alerting();
    }
}
