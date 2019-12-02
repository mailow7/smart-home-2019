package ru.sbt.mipt.oop.EventMaker;

import ru.sbt.mipt.oop.Sensorevents.*;

import static ru.sbt.mipt.oop.Sensorevents.AlarmEventType.*;
import static ru.sbt.mipt.oop.Sensorevents.DoorEventType.*;
import static ru.sbt.mipt.oop.Sensorevents.LightEventType.*;


public class GetSmarthomeEventRandom{

    public static SensorEvent getEvent() {

        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        String objectId = "" + ((int) (10 * Math.random()));
        int itype = (int) (4 * Math.random());
        boolean bool = (Math.random() < 0.5);
        switch (itype) {
            case 1:
                return new DoorEvent(objectId, bool?DOOR_CLOSED : DOOR_OPEN);
            case 2:
                return new LightEvent(objectId, bool?LIGHT_ON : LIGHT_OFF);
            case 3:
                return new AlarmEvent("pin",bool?ALARM_ACTIVATE : ALARM_DEACTIVATE);

        }


        return null;
    }
}
