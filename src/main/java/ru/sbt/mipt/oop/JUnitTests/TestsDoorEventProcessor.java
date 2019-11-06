package ru.sbt.mipt.oop.JUnitTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateReader;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class TestsDoorEventProcessor {

    @Test
    public void CheckEventProcessorLightOnWhenDoorOpen() {

        HomeStateReader homeStateReader = new GetSmarthomefromJSON();
        SmartHome smartHome = homeStateReader.getState();
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor();

        dooreventprocessor.handle(smartHome, new SensorEvent(DOOR_CLOSED, "1"));

        assertFalse(isDoorOpeninSmarthomebyID(smartHome, "1"));

        dooreventprocessor.handle(smartHome, new SensorEvent(DOOR_OPEN, "1"));

        assertTrue(isDoorOpeninSmarthomebyID(smartHome, "1"));
    }

    public boolean isDoorOpeninSmarthomebyID(SmartHome smartHome, String DoorId) {
        // событие от двери
        final boolean[] open = {false};
        smartHome.execute(obj -> {
            if (obj instanceof Door) {
                if (((Door) obj).getId().equals(DoorId)) {
                    open[0] = ((Door) obj).isOpen();


                }
            }
        });
        return open[0];
    }

}
