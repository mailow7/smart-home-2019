package ru.sbt.mipt.oop.remoteControl;

import rc.RemoteControl;

import java.util.HashMap;
import java.util.Map;

public class SmarthomeRemotecontrol implements RemoteControl {

    private final Map<String, RemoteControlCommand> commands;
    private String rcId;

    public SmarthomeRemotecontrol() {
        commands = new HashMap<>();
    }

    public void setRcId(String rcId) {
        this.rcId = rcId;
    }

    public void  addCommand(String buttonCode, RemoteControlCommand command) {
        commands.put(buttonCode, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {

        if (rcId.equals(this.rcId) && commands.containsKey(buttonCode)) {
            commands.get(buttonCode).execute();
        }
    }
}
