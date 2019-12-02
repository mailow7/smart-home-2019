package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Commands.SetAllLightOff;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Sensorevents.DoorEventType;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class HallDoorProcessor implements EventProcessor {

    private SmartHome smartHome;

    public HallDoorProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle(SensorEvent event) {

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