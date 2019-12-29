package ru.sbt.mipt.oop.adapter.converter;

import ru.sbt.mipt.oop.sensorevents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;


public interface CCSensorEventConverter {

    SensorEvent convert(CCSensorEvent ccSensorEvent);
}
