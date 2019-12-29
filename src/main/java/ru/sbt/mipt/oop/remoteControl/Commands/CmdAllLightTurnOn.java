package ru.sbt.mipt.oop.remoteControl.Commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.parts.Light;
import ru.sbt.mipt.oop.remoteControl.RemoteControlCommand;

public class CmdAllLightTurnOn implements RemoteControlCommand {
    boolean turnOn;
    SmartHome smartHome;

    public CmdAllLightTurnOn(SmartHome smartHome, boolean turnOn) {
        this.smartHome = smartHome;
        this.turnOn = turnOn;
    }

    @Override
    public void execute() {
        smartHome.execute(light -> {
            if (light instanceof Light) {
                ((Light) light).setOn(turnOn);

            }
        });
    }
}
