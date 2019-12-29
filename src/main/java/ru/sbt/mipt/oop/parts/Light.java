package ru.sbt.mipt.oop.parts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Light implements Actionable {
    private final String id;
    private boolean isOn;

    @Override
    public void execute(Action action) {
        action.executeObject(this);
    }

    public Light(String id, Boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

}
