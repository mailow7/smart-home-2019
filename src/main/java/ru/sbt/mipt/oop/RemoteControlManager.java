package ru.sbt.mipt.oop;

import rc.RemoteControl;
import ru.sbt.mipt.oop.Commands.Command;

import java.util.HashMap;

public class RemoteControlManager implements RemoteControl {

    private HashMap<String, Command> buttonsCommand;


    public void putCommand(String buttonCode, Command command){
        buttonsCommand.put(buttonCode, command);
    }


    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if(buttonsCommand.containsKey(buttonCode)){
            Command command = buttonsCommand.get(buttonCode);
            command.executeCommand();
        }
    }
}
