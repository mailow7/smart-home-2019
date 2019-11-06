package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Commands.SetAllLightOff;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class HallDoorProcessor implements EventProcessor {
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
        return(event.getType() == SensorEventType.DOOR_CLOSED);
    }
}
