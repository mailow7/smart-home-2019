package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome;

public class SetAlarmActivated implements Command {

    private SmartHome smartHome;
    private String code;

    public SetAlarmActivated(SmartHome smartHome, String code) {
        this.smartHome = smartHome;
        this.code = code;
    }

    @Override
    public void executeCommand() {
        Alarm alarm = smartHome.getAlarm();
        alarm.activateAlarm(code);
    }
}
