package ru.sbt.mipt.oop;

public class Door{
    private final String id;
    private boolean isOpen;



    public Door(String id, boolean isOpen) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public void add(String id, boolean isOpen) {
        new Door(id, isOpen);
    }

     String getId() {
        return id;
    }

     void setOpen(boolean state) {
        isOpen = state;
    }
}