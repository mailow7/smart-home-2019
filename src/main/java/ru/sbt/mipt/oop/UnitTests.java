package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    public void CheckEventProcessorLightOnWhenDoorOpen() {
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor();

        SmartHome smartHome = new SmartHome();
        smartHome.GetHomeState();
        Room room = smartHome.getRoom("hall");

        Boolean LightisOn = true;

        for (Light light : room.getLights()) {
            light.setOn(false);
        }

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN,"4");
        dooreventprocessor.handle(smartHome,event1);

        for (Light light : room.getLights()) {
            if(!light.isOn()){
               LightisOn=false;
            }
        }

        assertEquals(true,LightisOn);

    }

}
