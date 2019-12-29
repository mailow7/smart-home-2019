package ru.sbt.mipt.oop.adapter.converter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensorevents.DoorEvent;
import ru.sbt.mipt.oop.sensorevents.DoorEventType;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.sensorevents.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensorevents.DoorEventType.DOOR_OPEN;

public class CCSensorEventDoorConverter implements CCSensorEventConverter {

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        DoorEventType type = null;

        if (ccSensorEvent.getEventType().equals("DoorIsOpen")) {
            type = DOOR_OPEN;
        }
        if (ccSensorEvent.getEventType().equals("DoorIsClosed")) {
            type = DOOR_CLOSED;
        }
        if (type != null) {
            return new DoorEvent(ccSensorEvent.getObjectId(), type);
        } else {
            return null;
        }

    }
}
