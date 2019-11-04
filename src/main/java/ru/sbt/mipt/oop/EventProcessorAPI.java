package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

public class EventProcessorAPI implements EventHandler {

    private EventProcessor eventProcessor;

    public EventProcessorAPI(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    public EventProcessorAPI() {

    }

    @Override
    public void handleEvent(CCSensorEvent CCevent) {

        SensorEventAdapter eventAdapter = new SensorEventAdapter();
        SensorEvent sensorEvent = eventAdapter.getEventTypeFromString(CCevent);
        eventProcessor.handle(sensorEvent);

    }
}
