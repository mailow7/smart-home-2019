package ru.sbt.mipt.oop;

public class SensorCommand {

    public enum CommandType {
        LIGHT_OFF
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


    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

}


