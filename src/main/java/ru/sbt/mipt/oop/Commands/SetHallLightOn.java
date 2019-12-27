package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Collection;

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
