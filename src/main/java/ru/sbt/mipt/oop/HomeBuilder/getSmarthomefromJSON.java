package ru.sbt.mipt.oop.HomeBuilder;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class getSmarthomefromJSON implements HomeState {

    @Override
    public SmartHome GetState() {

        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("output.js")));
            SmartHome smartHome = gson.fromJson(json, SmartHome.class);
            return smartHome;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
