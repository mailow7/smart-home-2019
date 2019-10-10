package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {

    private SmartHome smartHome;
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

     void GetHomeEvents() {
        smartHome = HomeEvents.GetEvents();
    }

     void CheckHomeEvents() {
        HomeEvents.CheckEvents(smartHome);

    }
}
