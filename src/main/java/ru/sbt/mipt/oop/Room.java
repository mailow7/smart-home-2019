package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room {
    private String name;
    private Collection<Light> lights;
    private Collection<Door> doors;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.name = name;
        this.lights = lights;
        this.doors = doors;
    }

    public Room(String name) {
        this.name = name;
    }

     Collection<Light> getLights() {
        return lights;
    }

     Collection<Door> getDoors() {
        return doors;
    }

     String getName() {
        return name;
    }

     void AddLight(String id, Light.LightState ls) {
       this.lights.add(new Light(id ,ls));
    }

     void AddDoor(String id, Door.DoorState isOpen) {
        this.doors.add(new Door(id, isOpen));
    }
}
