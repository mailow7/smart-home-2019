package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.AlarmActivated;
import ru.sbt.mipt.oop.Alarm.AlarmAlerting;
import ru.sbt.mipt.oop.Alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.Alarm.AlarmStatus;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.Messanger.MessageSender;
import ru.sbt.mipt.oop.Messanger.MessageSenderConsole;
import ru.sbt.mipt.oop.Sensorevents.AlarmEvent;
import ru.sbt.mipt.oop.Sensorevents.SensorEvent;

import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.ALARM_DEACTIVATE;

public class DecoratorEvent implements EventProcessor {

    private EventProcessor processor;

    public DecoratorEvent(EventProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        AlarmStatus status = smartHome.homeAlarm.getStatus();
        MessageSender messageSender = new MessageSenderConsole();
        messageSender.send("Got event: " + event);

//        if (event instanceof AlarmActivated) {
//            smartHome.getHomeAlarm().alarmAlerting();
//        }
//        else

        if(event instanceof AlarmEvent ) {
            if (((AlarmEvent) event).getType() == ALARM_DEACTIVATE || status instanceof AlarmDeactivated) {
                processor.handle(smartHome, event);
            } else {
                smartHome.getHomeAlarm().alarmAlerting();
            }
        }else{
            if(status instanceof AlarmDeactivated){
                processor.handle(smartHome, event);
            }else{
                smartHome.getHomeAlarm().alarmAlerting();
            }

        }


    }

}
