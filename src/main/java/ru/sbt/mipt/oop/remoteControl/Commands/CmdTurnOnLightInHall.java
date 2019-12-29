package ru.sbt.mipt.oop.remoteControl.Commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.parts.Light;
import ru.sbt.mipt.oop.parts.Room;
import ru.sbt.mipt.oop.remoteControl.RemoteControlCommand;

public class CmdTurnOnLightInHall implements RemoteControlCommand {
    SmartHome smartHome;

    public CmdTurnOnLightInHall(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(room -> {
            if (room instanceof Room && ((Room) room).getName().equals("hall")) {
                ((Room) room).execute(light -> {
                    if (light instanceof Light) {
                        ((Light) light).setOn(false);
                    }
                });
            }
        });
    }
}

