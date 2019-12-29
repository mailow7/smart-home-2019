package ru.sbt.mipt.oop.remoteControl.Commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.remoteControl.RemoteControlCommand;


public class CmdActivateAlarm implements RemoteControlCommand {
    SmartHome smartHome;

    public CmdActivateAlarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(alarm -> {
            if (alarm instanceof HomeAlarm) {
                ((HomeAlarm) alarm).activate("");
            }
        });


    }
}
