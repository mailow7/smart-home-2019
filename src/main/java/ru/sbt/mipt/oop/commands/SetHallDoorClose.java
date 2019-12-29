package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.parts.Room;
import ru.sbt.mipt.oop.SmartHome;

public class SetHallDoorClose implements Command {

    private SmartHome smartHome;

    public SetHallDoorClose(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.execute(obj -> {
            if(obj instanceof Room && ((Room) obj).getName().equals("hall")){
//                Collection<Door> doors = ((Room) obj).getDoors();
//                for (Door door : doors){
//                    door.setOpen(false);
//                }
            }
        });
    }

}
