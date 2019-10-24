package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    public void DoorEventProcessorReturnTrue() {
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor();
        assertEquals(true, dooreventprocessor.Work());
        assertNotEquals(false, dooreventprocessor.Work());
        assertTrue(dooreventprocessor.Work());
    }

    @Test
    public void DoorEventProcessorReturnFasle() {
        DoorEventProcessor dooreventprocessor = new DoorEventProcessor();
        assertEquals(false, dooreventprocessor.ReturnFalse());
        assertNotEquals(true, dooreventprocessor.ReturnFalse());
        assertFalse(dooreventprocessor.ReturnFalse());
    }

}
