package ru.sbt.mipt.oop.adapter.converter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

import java.util.List;

public class CCSensorEventConverterIterate {

    private List<CCSensorEventConverter> converters;

    public SensorEvent getSensorEvent(CCSensorEvent event) {
        for (CCSensorEventConverter converter : converters) {
            SensorEvent sensorEvent = converter.convert(event);
            if (sensorEvent != null) return sensorEvent;
        }
        return null;
    }
}
