package ru.sbt.mipt.oop;


public enum SensorEventType {
    LIGHT_ON(""), LIGHT_OFF(""), DOOR_OPEN(""), DOOR_CLOSED(""),
    ALARM_ACTIVATE("123"), ALARM_DEACTIVATE("");


    private final String code;

    SensorEventType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
