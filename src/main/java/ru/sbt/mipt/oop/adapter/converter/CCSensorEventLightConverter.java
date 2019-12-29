package ru.sbt.mipt.oop.adapter.converter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensorevents.LightEvent;
import ru.sbt.mipt.oop.sensorevents.LightEventType;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.sensorevents.LightEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.sensorevents.LightEventType.LIGHT_ON;

public class CCSensorEventLightConverter implements CCSensorEventConverter {


    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        LightEventType type = null;

        if (ccSensorEvent.getEventType().equals("LightIsOn")) {
            type = LIGHT_ON;
        }
        if (ccSensorEvent.getEventType().equals("LightIsOff")) {
            type = LIGHT_OFF;
        }
        if (type != null) {
            return new LightEvent(ccSensorEvent.getObjectId(), type);
        } else {
            return null;
        }
    }
}
