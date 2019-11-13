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

        for (Door d : doors) d.execute(action);
        for (Light l : lights) l.execute(action);
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

}
