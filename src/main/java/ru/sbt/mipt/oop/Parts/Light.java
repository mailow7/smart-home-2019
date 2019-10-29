package ru.sbt.mipt.oop.Parts;

public class Light {
    private final String id;
    private boolean isOn;

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
