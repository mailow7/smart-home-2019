package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Sensorevents.DoorEvent;
import ru.sbt.mipt.oop.Sensorevents.DoorEventType;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.Sensorevents.DoorEventType.DOOR_OPEN;


public class DoorEventProcessor implements EventProcessor {

    private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }



    private Action parseEvent(Object event) {
        if (event instanceof DoorEvent) {
            DoorEvent doorSensorEvent = (DoorEvent) event;

            return obj -> {
                if (!(obj instanceof Door)) {
                    return;
                }
                Door door = (Door) obj;
                if (door.getId().equals(doorSensorEvent.getObjectId())) {
                    door.setOpen(doorSensorEvent.getType()==DOOR_OPEN);
                }

            };
        }else{
            return  null;
        }
    }


    @Override
    public void handle(SensorEvent event) {
        // событие от двери

        Action action = parseEvent(event);
        smartHome.execute(action);

    }




    /*private void doorHandle(Door obj, SensorEvent event) {
        if (obj.getId().equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                setDoor(obj, true, "opened.");
            } else {
                setDoor(obj, false, "closed.");
            }
        }
    }

    private boolean sensorDoorEvent(SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            return true;
        } else {
            return false;
        }
    }*/


    private void setDoor(Door door, boolean condition, String openess) {
        door.setOpen(condition);
        System.out.println("Door " + door.getId() + " was " + openess);
    }
}
