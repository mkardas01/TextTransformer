package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverterTest {
    @Test
    public void testTransformWithLowerCase() {
        Inverter inverter = new Inverter();
        assertEquals("elpmaxe", inverter.transform("example"));
    }

    @Test
    public void testTransformWithUpperCase() {
        Inverter inverter = new Inverter();
        assertEquals("Elpmaxe", inverter.transform("Example"));
    }

    @Test
    public void testTransformWithMixedCase() {
        Inverter inverter = new Inverter();
        assertEquals("DlrowOlleh", inverter.transform("HelloWorld"));
    }

    @Test
    public void testTransformWithSpaces() {
        Inverter inverter = new Inverter();
        assertEquals("GnirtS tset", inverter.transform("Test String"));
    }

    @Test
    public void testTransformWithSpaceMixedCase() {
        Inverter inverter = new Inverter();
        assertEquals("Tset TSeJ OT", inverter.transform("To jeST TeST"));
    }

    @Test
    public void testTransformWithSpecialCharacters() {
        Inverter inverter = new Inverter();
        assertEquals("#@!321", inverter.transform("123!@#"));
    }

    @Test
    public void testTransformWithEmptyString() {
        Inverter inverter = new Inverter();
        assertEquals("", inverter.transform(""));
    }

}