package ru.sbt.mipt.oop;

public class SensorCommand {

    public enum CommandType {
        LIGHT_OFF,LIGHT_ON
    }


    private final CommandType type;
    private final String objectId;

    @Override
    public String toString() {
        return "SensorCommand{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }

    public SensorCommand(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

}


