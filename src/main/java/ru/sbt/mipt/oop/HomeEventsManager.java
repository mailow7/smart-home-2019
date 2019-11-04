package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

public interface HomeEventsManager {
    void start();

    void registerEventProcessor(EventProcessor eventProcessor);


}
