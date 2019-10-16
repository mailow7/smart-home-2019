package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetHomeStateFromJson implements HomeState {

    @Override
    public SmartHome GetState() {

        // считываем состояние дома из файла
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get("output.js")));
            return gson.fromJson(json, SmartHome.class);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
