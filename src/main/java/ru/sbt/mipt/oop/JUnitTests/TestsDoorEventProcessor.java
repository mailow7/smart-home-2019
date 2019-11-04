package ru.sbt.mipt.oop.JUnitTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.HomeBuilder.HomeState;
import ru.sbt.mipt.oop.HomeBuilder.getSmarthomefromJSON;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class TestsDoorEventProcessor {

    private HomeState homeState = new getSmarthomefromJSON();

    @Test
    public void CheckEventProcessorLightOnWhenDoorOpen() {


        SmartHome smartHome = homeState.GetState();
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor(smartHome);

        dooreventprocessor.handle(new SensorEvent(DOOR_CLOSED, "1"));

        assertFalse(isDoorOpeninSmarthomebyID(smartHome, "1"));

        dooreventprocessor.handle(new SensorEvent(DOOR_OPEN, "1"));

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
