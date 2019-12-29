package ru.sbt.mipt.oop.sensorevents;

public class AlarmEvent implements SensorEvent {
    private final String pin;
    private final AlarmEventType type;

    public AlarmEvent(String pin, AlarmEventType type) {
        this.pin = pin;
        this.type = type;
    }

    public String getPin() {
        return pin;
    }

    public AlarmEventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "AlarmSensorEvent{" +
                "code='" + pin + '\'' +
                ", type=" + type.toString() +
                '}';
    }
}
