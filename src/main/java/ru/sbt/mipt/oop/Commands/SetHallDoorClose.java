package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Collection;

public class SetHallDoorClose implements Command {

    private SmartHome smartHome;

    public SetHallDoorClose(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.execute(obj -> {
            if(obj instanceof Room && ((Room) obj).getName().equals("hall")){
                Collection<Door> doors = ((Room) obj).getDoors();
                for (Door door : doors){
                    door.setOpen(false);
                }
            }
        });
    }

}
