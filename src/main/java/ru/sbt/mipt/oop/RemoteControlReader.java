package ru.sbt.mipt.oop;

import rc.RemoteControl;

import java.util.HashMap;

public interface RemoteControlReader {
    HashMap<String, RemoteControl> readRemoteControl();
}
