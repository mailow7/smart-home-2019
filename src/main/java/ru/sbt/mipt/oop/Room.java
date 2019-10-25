package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
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

     void AddLight(String id, boolean ls) {
       this.lights.add(new Light(id ,ls));
    }

     void AddDoor(String id, boolean isOpen) {
        this.doors.add(new Door(id, isOpen));
    }

    @Override
    public void execute(Action action) {

    }
}
