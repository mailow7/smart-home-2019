package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {

        // событие от источника света
        if (sensorLightEvent(event)) {
            smartHome.execute(obj -> {
                if (obj instanceof Light) {
                    lightHandle((Light) obj, event);
                }
            });
        }
    }

    private void lightHandle(Light obj, SensorEvent event) {
        if (obj.getId().equals(event.getObjectId())) {
            if (event.getType() == LIGHT_ON) {
                setLightOn(obj, true, "turned on.");
            } else {
                setLightOn(obj, false, "turned off.");
            }
        }
    }

    private boolean sensorLightEvent(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            return true;
        } else {
            return false;
        }
    }

    private void setLightOn(Light light, boolean condition, String cond) {
        light.setOn(condition);
        System.out.println("Light " + light.getId() + " was " + cond);
    }
}
