package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapter.SmarthomeEventAdapter;
import ru.sbt.mipt.oop.adapter.converter.CCSensorEventConverter;
import ru.sbt.mipt.oop.eventProcessors.*;
import ru.sbt.mipt.oop.homeBuilders.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.messanger.MessageSender;
import ru.sbt.mipt.oop.messanger.MessageSenderConsole;

import java.util.Collection;

@Configuration
public class SmartHomeConfiguration {

    @Bean
    public SensorEventsManager sensorEventsManager(EventProcessor eventProcessor, SmartHome smartHome, CCSensorEventConverter ccSensorEventConverter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new SmarthomeEventAdapter(eventProcessor, smartHome, ccSensorEventConverter));
        return sensorEventsManager;
    }

    @Bean
    public SmartHome smartHome() {
        return new GetSmarthomefromJSON().getState();
    }

    @Bean
    public EventProcessor eventProcess(Collection<EventHandler> collectionEventProcess) {
        MessageSender messageSender = new MessageSenderConsole();
        return new DecorateAlarmEventProcessor(new HomeProcessor(collectionEventProcess), messageSender);
    }

    @Bean
    public EventHandler lightEventProcessor() {
        return new LightEventProcessor();
    }

    @Bean
    public EventHandler doorEventProcessor() {
        return new DoorEventProcessor();
    }

    @Bean
    public EventHandler hallEventProcessor() {
        return new HallDoorProcessor();
    }

    @Bean
    public EventHandler alarmEventProcessor() {
        return new AlarmEventProcessor();
    }


}
