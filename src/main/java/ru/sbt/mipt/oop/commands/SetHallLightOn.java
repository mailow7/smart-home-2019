package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.parts.Room;
import ru.sbt.mipt.oop.SmartHome;

public class SetHallLightOn implements Command {

    private SmartHome smartHome;

    public SetHallLightOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.execute(obj -> {
            if(obj instanceof Room && ((Room) obj).getName().equals("hall")){
//                Collection<Light> lights = ((Room) obj).getLights();
//                for (Light light : lights){
//                    light.setOn(true);
//                }
            }
        });
    }
}
