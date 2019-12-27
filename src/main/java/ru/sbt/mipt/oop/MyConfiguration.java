package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.GetHomeProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class MyConfiguration {

    private SmartHome smartHome;
    private HomeEventsManager eventsManager;


    @Bean
    @Description("smarthome")
    SmartHome getSmartHome() {
        return smartHome;
    }

    @Bean
    @Description("eventsManager")
    HomeEventsManager getEventsManager() {
        return eventsManager;
    }

//    private ArrayList<EventProcessor> createProcessors(SmartHome smartHome) {
//
//        Collection<EventProcessor> eventProcessors = GetHomeProcessor.getHomeProcessor();
//        return (ArrayList<EventProcessor>) eventProcessors;
//    }

}
