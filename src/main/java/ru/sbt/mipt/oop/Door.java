package ru.sbt.mipt.oop;

public class Door{
    private final String id;
    private DoorState is;

    enum DoorState {
        OPEN, CLOSED
    }

    public Door(String id, DoorState isOpen) {
        this.is = isOpen;
        this.id = id;
    }

    public void add(String id, DoorState isOpen) {
        new Door(id, isOpen);
    }

     String getId() {
        return id;
    }

     void setOpen(DoorState state) {
        is = state;
    }
}