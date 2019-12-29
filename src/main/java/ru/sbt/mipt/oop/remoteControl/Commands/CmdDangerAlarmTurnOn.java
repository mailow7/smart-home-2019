package ru.sbt.mipt.oop.remoteControl.Commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.messanger.MessageSenderConsole;
import ru.sbt.mipt.oop.remoteControl.RemoteControlCommand;

public class CmdDangerAlarmTurnOn implements RemoteControlCommand {
    private SmartHome smartHome;

    public CmdDangerAlarmTurnOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(homeAlarm -> {
            if (homeAlarm instanceof HomeAlarm) {
                ((HomeAlarm) homeAlarm).alerting(new MessageSenderConsole());
            }
        });
    }
}
