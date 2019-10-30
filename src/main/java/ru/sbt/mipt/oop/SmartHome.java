package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Parts.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

    Collection<Room> rooms;

    @Override
    public void execute(Action action) {
        action.executeObject(this);

            for(Room room: rooms){
                room.execute(action);
            }
    }

    public SmartHome() {
        rooms = new ArrayList<>();
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


}
