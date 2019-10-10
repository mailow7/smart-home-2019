package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static ru.sbt.mipt.oop.Door.DoorState.CLOSED;
import static ru.sbt.mipt.oop.Door.DoorState.OPEN;
import static ru.sbt.mipt.oop.Light.LightState.OFF;
import static ru.sbt.mipt.oop.Light.LightState.ON;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Room kitchen = new Room(Arrays.asList(new Light("1", Light.LightState.OFF), new Light("2", Light.LightState.ON)),
                Arrays.asList(new Door("1", Door.DoorState.CLOSED)),
                "kitchen");
        Room bathroom = new Room(Arrays.asList(new Light("3", Light.LightState.ON)),
                Arrays.asList(new Door("2",Door.DoorState.CLOSED)),
                "bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", Light.LightState.OFF), new Light("5", Light.LightState.OFF), new Light("6", Light.LightState.OFF)),
                Arrays.asList(new Door("3", Door.DoorState.OPEN)),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", Light.LightState.OFF), new Light("8", Light.LightState.OFF), new Light("9", Light.LightState.OFF)),
                Arrays.asList(new Door("4",Door.DoorState.CLOSED)),
                "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }


    public static void Build() {
        Room kitchen = new Room("Kitchen");
        Room bathroom = new Room("bathroom");
        Room bedroom = new Room("bedroom");
        Room hall = new Room("hall");

        kitchen.AddLight("1", OFF);
        kitchen.AddLight("2", OFF);
        kitchen.AddDoor("1", CLOSED);

        bathroom.AddLight("3", ON);
        bathroom.AddDoor("2", CLOSED);

        bedroom.AddLight("4",OFF);
        bedroom.AddLight("5",OFF);
        bedroom.AddLight("6",OFF);
        bedroom.AddDoor("3",OPEN);

        hall.AddLight("7",OFF);
        hall.AddLight("8",OFF);
        hall.AddLight("9",OFF);
        hall.AddDoor("4",CLOSED);

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}