package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.EventHandler;
import ru.sbt.mipt.oop.commands.SetAllLightOff;
import ru.sbt.mipt.oop.parts.Room;
import ru.sbt.mipt.oop.sensorevents.DoorEventType;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class HallDoorProcessor implements EventHandler {


    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {

        if (isSensorDoorClosedEvent(event))
            smartHome.execute(obj -> {
                if(obj instanceof Room && ((Room) obj).getName().equals("hall")){
                    SetAllLightOff setAllLightOff = new SetAllLightOff(smartHome);
                    setAllLightOff.executeCommand();
                }
            });
    }

    private boolean isSensorDoorClosedEvent(SensorEvent event) {
        return(event instanceof DoorEventType);
    }

}