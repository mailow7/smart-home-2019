package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.EventHandler;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.parts.Door;
import ru.sbt.mipt.oop.sensorevents.DoorEvent;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.sensorevents.DoorEventType.DOOR_OPEN;


public class DoorEventProcessor implements EventHandler {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {

        if (event instanceof DoorEvent) {
            smartHome.execute(obj -> {
                if (obj instanceof Door) {
                    doorHandle((Door) obj, event);
                }
            });

        }
    }

    private void doorHandle(Door door, SensorEvent event) {

        DoorEvent doorEvent = (DoorEvent) event;
        if (door.getId().equals(doorEvent.getObjectId())) {
            if (((DoorEvent) event).getType() == DOOR_OPEN) {
                changeDoorState(door, true, "opened.");
            } else {
                changeDoorState(door, false, "closed.");
            }
        }

    }

    private void changeDoorState(Door door, boolean condition, String cond) {
        door.setOpen(condition);
        System.out.println("Door " + door.getId() + " was " + cond);
    }
}





