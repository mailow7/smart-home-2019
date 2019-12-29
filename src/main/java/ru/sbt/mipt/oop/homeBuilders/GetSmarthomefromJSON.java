package ru.sbt.mipt.oop.homeBuilders;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetSmarthomefromJSON implements HomeStateBuilder {

    @Override
    public SmartHome getState() {

        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("output.js")));
            return gson.fromJson(json, SmartHome.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
