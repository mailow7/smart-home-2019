package ru.sbt.mipt.oop.sensorevents;

public class LightEvent extends SensorEventID{
        private final LightEventType type;

    public LightEvent(String objectId, LightEventType type) {
        super(objectId);
        this.type = type;
    }

    public LightEventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "LightEvent{" +
                "type=" + type.toString() +
                ",id=" + getObjectId() +
                '}';
    }
}
