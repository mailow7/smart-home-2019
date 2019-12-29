package ru.sbt.mipt.oop.sensorevents;

public class SensorEventID implements SensorEvent{
    private final String objectId;

protected SensorEventID(String objectId){
    this.objectId  = objectId;
    }

    public String getObjectId() {
        return objectId;
    }
}
