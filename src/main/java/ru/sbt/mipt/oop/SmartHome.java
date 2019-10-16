package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorCommand.sendCommand;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class SmartHome {

    private SmartHome smartHome;

    private HomeState smartHomeState;
    private SensorEvent smartHomeEvents;
    private Collection<Room> rooms;


    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

     Collection<Room> getRooms() {
        return rooms;
    }


    public void GetHomeState() {
        HomeState hs = new GetHomeStateFromJson();
        if(hs.GetState() != null)
            smartHome = hs.GetState();

    }

    public void GetHomeEvents() {

        // начинаем цикл обработки событий
        GetSmarthomeEvent se = new GetSmarthomeEventRandom();
        SensorEvent event =  se.GetEvent();

        while (event != null) {
           CheckHomeEvents(event);
            event = se.GetEvent();
        }
    }

    public void CheckHomeEvents(SensorEvent event) {
        System.out.println("Got event: " + event);
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            // событие от источника света
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            light.setOn(false);
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
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                            if (room.getName().equals("hall")) {
                                for (Room homeRoom : smartHome.getRooms()) {
                                    for (Light light : homeRoom.getLights()) {
                                        light.setOn(true);
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
    }
}
