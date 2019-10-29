package ru.sbt.mipt.oop.Parts;

public class Door {
    private final String id;
    private boolean isOpen;


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
}