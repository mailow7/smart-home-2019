package ru.sbt.mipt.oop.JUnitTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.HomeBuilder.GetSmarthomefromJSON;
import ru.sbt.mipt.oop.HomeBuilder.HomeStateBuilder;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.SmartHome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsDoorEventProcessor {

    private HomeStateBuilder homeStateBuilder = new GetSmarthomefromJSON();

    @Test
    public void CheckEventProcessorLightOnWhenDoorOpen() {


        SmartHome smartHome = homeStateBuilder.getState();
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor();


        assertFalse(isDoorOpeninSmarthomebyID(smartHome, "1"));


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
