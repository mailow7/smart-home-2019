package ru.sbt.mipt.oop.remoteControl.Commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.parts.Door;
import ru.sbt.mipt.oop.parts.Room;
import ru.sbt.mipt.oop.remoteControl.RemoteControlCommand;

public class CmdCloseHallDoor implements RemoteControlCommand {
    SmartHome smartHome;

    public CmdCloseHallDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(room -> {
            if (room instanceof Room && ((Room) room).getName().equals("hall")) {
                ((Room) room).execute(door -> {
                    if (door instanceof Door) {
                        ((Door) door).setOpen(false);
                    }
                });
            }
        });
    }
}
