package ru.sbt.mipt.oop.Sensorevents;

public class DoorEvent extends SensorEventID{
    private final DoorEventType type;

    public DoorEvent(String objectId, DoorEventType type) {
        super(objectId);
        this.type = type;
    }

    public DoorEventType getType() {
        return type;
    }



    @Override
    public String toString() {
        return "DoorEvent{" +
                "type=" + type.toString() +
                ",id=" + getObjectId()   +
                '}';
    }
}
