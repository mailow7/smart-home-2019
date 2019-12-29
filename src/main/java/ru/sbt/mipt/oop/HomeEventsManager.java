package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventProcessors.EventProcessor;

public interface HomeEventsManager {
    void start();

    void registerEventProcessor(EventProcessor eventProcessor);


}
