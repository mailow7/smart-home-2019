package ru.sbt.mipt.oop.Parts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

import java.util.Collection;
import java.util.Iterator;

public class Room implements Actionable {
    private String name;
    private Collection<Light> lights;
    private Collection<Door> doors;

    @Override
    public void execute(Action action) {
        action.executeObject(this);

        Iterator<Door> doorIterator = this.doors.iterator();
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            door.execute(action);
        }

        Iterator<Light> lightIterator = this.lights.iterator();
        while (lightIterator.hasNext()) {
            Light light = lightIterator.next();
            light.execute(action);
        }
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.name = name;
        this.lights = lights;
        this.doors = doors;
    }

    public Room(String name) {
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public void AddLight(String id, boolean ls) {
        this.lights.add(new Light(id, ls));
    }

    public void AddDoor(String id, boolean isOpen) {
        this.doors.add(new Door(id, isOpen));
    }


}
