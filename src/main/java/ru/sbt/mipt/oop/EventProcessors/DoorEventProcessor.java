package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.SensorCommand;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void handle(SensorEvent event) {
        // событие от двери
        if (sensorDoorEvent(event)) {
            smartHome.execute(obj -> {
                if (obj instanceof Door) {

                    doorHandle((Door) obj, event);
                }
            });
        }
    }

    private void doorHandle(Door obj, SensorEvent event) {
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
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private void setDoor(Door door, boolean condition, String openess) {
        door.setOpen(condition);
        System.out.println("Door " + door.getId() + " was " + openess);
    }
}
