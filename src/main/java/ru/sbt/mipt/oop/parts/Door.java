package ru.sbt.mipt.oop.parts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

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