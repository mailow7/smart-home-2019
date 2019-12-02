package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Sensorevents.LightEvent;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class LightEventProcessor implements EventProcessor {

    private SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle(SensorEvent event) {

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
            changeLightState(light, true, "turned on.");
        } else {
            changeLightState(light, false, "turned off.");
        }

    }

    private void changeLightState(Light light, boolean condition, String cond) {
        light.setOn(condition);
        System.out.println("Light " + light.getId() + " was " + cond);
    }
}
