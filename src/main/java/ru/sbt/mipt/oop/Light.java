package ru.sbt.mipt.oop;

public class Light implements Actionable
{


    private final String id;
    private boolean isOn;


    public Light(String id, Boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

     String getId() {
        return id;
    }

     void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void execute(Action action) {

    }
}
