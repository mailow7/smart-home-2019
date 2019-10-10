package ru.sbt.mipt.oop;

public class Light
{

    enum LightState {
        ON, OFF
    }
    private final String id;
    private LightState is;

    public Light(String id, LightState isOn) {
        this.id = id;
        this.is = isOn;
    }

    public LightState isOn() {
        return is;
    }

     String getId() {
        return id;
    }

     void setOn(LightState state) {
        is = state;
    }

}
