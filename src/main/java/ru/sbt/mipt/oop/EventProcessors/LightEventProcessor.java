package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    private SmartHome smartHome;

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {

        // событие от источника света
        if (sensorLightEvent(event)) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == LIGHT_ON) {
                            setLightOn(room, light, true, "turned on.");
                        } else {
                            setLightOn(room, light, false, "turned off.");
                        }
                    }
                }
            }
        } else {
            // событие не от источника света
            return;
        }
    }

    private boolean sensorLightEvent(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            return true;
        } else {
            return false;
        }
    }

    private void setLightOn(Room room, Light light, boolean condition, String cond) {
        light.setOn(condition);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was " + cond);
    }
}
