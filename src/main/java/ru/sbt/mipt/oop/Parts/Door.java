package ru.sbt.mipt.oop.Parts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

import javax.accessibility.Accessible;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    @Override
    public void execute(Action action) {
        action.executeObject(this);
    }
    public Door(String id, boolean isOpen) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public void add(String id, boolean isOpen) {
        new Door(id, isOpen);
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean state) {
        isOpen = state;
    }

    public boolean isOpen() {
        return isOpen;
    }
}