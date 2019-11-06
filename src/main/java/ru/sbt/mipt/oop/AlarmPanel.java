package ru.sbt.mipt.oop;

import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.Commands.Command;

import java.util.HashMap;

public class AlarmPanel implements RemoteControl {

    HashMap<String, Command> buttonsCommand;

    AlarmPanel(RemoteControlRegistry remoteControlRegistry) {
        this.buttonsCommand = new HashMap<>();
    }

    public void addCommand(String button, Command command) {
        buttonsCommand.put(button, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {

        Command command = buttonsCommand.get(buttonCode);
        command.executeCommand();


    }
}
