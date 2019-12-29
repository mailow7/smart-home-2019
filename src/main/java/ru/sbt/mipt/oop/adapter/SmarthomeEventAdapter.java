package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.adapter.converter.CCSensorEventConverterIterate;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.sensorevents.SensorEvent;

public class SmarthomeEventAdapter implements EventHandler {

    private final EventProcessor eventProcessor;
    private final SmartHome smartHome;
    private final CCSensorEventConverterIterate converter;

    public SmarthomeEventAdapter(EventProcessor eventProcessor, SmartHome smartHome, CCSensorEventConverterIterate converter) {
        this.eventProcessor = eventProcessor;
        this.smartHome = smartHome;
        this.converter = converter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = converter.getSensorEvent(event);
        eventProcessor.processEvent(smartHome, converter.getSensorEvent(event));

    }
}
