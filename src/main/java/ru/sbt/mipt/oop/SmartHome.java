package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.HomeAlarm;
import ru.sbt.mipt.oop.parts.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

    Collection<Room> rooms;
    protected HomeAlarm homeAlarm;

    public SmartHome() {
        rooms = new ArrayList<>();
        homeAlarm = new HomeAlarm("123");
    }

    @Override
    public void execute(Action action) {

        action.executeObject(this);

        for (Room room : rooms) {
            room.execute(action);
        }
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public HomeAlarm getHomeAlarm() {
        return homeAlarm;
    }

}
