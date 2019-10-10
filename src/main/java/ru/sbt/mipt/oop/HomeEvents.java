package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.Door.DoorState.CLOSED;
import static ru.sbt.mipt.oop.Door.DoorState.OPEN;
import static ru.sbt.mipt.oop.Light.LightState.OFF;
import static ru.sbt.mipt.oop.Light.LightState.ON;
import static ru.sbt.mipt.oop.SensorCommand.sendCommand;
import static ru.sbt.mipt.oop.HomeEvents.SensorEventType.*;

public class HomeEvents {

    enum SensorEventType {
        LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED
    }

    private final SensorEventType type;
    private final String objectId;

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }

    private HomeEvents(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    private SensorEventType getType() {
        return type;
    }

    private String getObjectId() {
        return objectId;
    }

    private static HomeEvents getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new HomeEvents(sensorEventType, objectId);
    }

     static SmartHome GetEvents() {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get("output.js")));
            return gson.fromJson(json, SmartHome.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


     static void CheckEvents(SmartHome smartHome) {
        // начинаем цикл обработки событий
        HomeEvents event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                for (Room room : smartHome.getRooms()) {
                    for (Light light : room.getLights()) {
                        if (light.getId().equals(event.getObjectId())) {
                            if (event.getType() == LIGHT_ON) {
                                light.setOn(ON);
                                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                            } else {
                                light.setOn(OFF);
                                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                            }
                        }
                    }
                }
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                // событие от двери
                for (Room room : smartHome.getRooms()) {
                    for (Door door : room.getDoors()) {
                        if (door.getId().equals(event.getObjectId())) {
                            if (event.getType() == DOOR_OPEN) {
                                door.setOpen(OPEN);
                                System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                            } else {
                                door.setOpen(CLOSED);
                                System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                                // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                                // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                                if (room.getName().equals("hall")) {
                                    for (Room homeRoom : smartHome.getRooms()) {
                                        for (Light light : homeRoom.getLights()) {
                                            light.setOn(OFF);
                                            SensorCommand command = new SensorCommand(SensorCommand.CommandType.LIGHT_OFF, light.getId());
                                            sendCommand(command);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            event = getNextSensorEvent();
        }
    }


}