package ru.sbt.mipt.oop.eventProcessors;

import ru.sbt.mipt.oop.EventHandler;
import ru.sbt.mipt.oop.parts.Light;
import ru.sbt.mipt.oop.sensorevents.LightEvent;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.sensorevents.LightEventType.LIGHT_ON;

public class LightEventProcessor implements EventHandler {


    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (event instanceof LightEvent) {

            smartHome.execute(obj -> {
                if (obj instanceof Light) {
                    lightHandle((Light) obj, event);
                }
            });
        }
    }


    private void lightHandle(Light light, SensorEvent event) {

        LightEvent lightEvent = (LightEvent) event;
        if (light.getId().equals(lightEvent.getObjectId())) {
            if (((LightEvent) event).getType() == LIGHT_ON) {
                changeLightState(light, true, "turned on.");
            } else {
                changeLightState(light, false, "turned off.");
            }
        }

    }

    private void changeLightState(Light light, boolean condition, String cond) {
        light.setOn(condition);
        System.out.println("Light " + light.getId() + " was " + cond);
    }


}
