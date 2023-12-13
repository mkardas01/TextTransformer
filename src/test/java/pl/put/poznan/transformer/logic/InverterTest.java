package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorators.InverterDecotaror;

import static org.junit.jupiter.api.Assertions.*;

class InverterTest {
    TextTransformer transformer;
    @BeforeEach
    public void init(){
        transformer = new TextTransformer (new String[]{"inverse"});
    }
    @Test
    public void testTransformWithLowerCase() {
        assertEquals("elpmaxe", transformer.transform("example"));
    }

    @Test
    public void testTransformWithUpperCase() {
        assertEquals("Elpmaxe", transformer.transform("Example"));
    }

    @Test
    public void testTransformWithMixedCase() {
        assertEquals("DlrowOlleh", transformer.transform("HelloWorld"));
    }

    @Test
    public void testTransformWithSpaces() {
        assertEquals("GnirtS tset", transformer.transform("Test String"));
    }

    @Test
    public void testTransformWithSpaceMixedCase() {
        assertEquals("Tset TSeJ OT", transformer.transform("To jeST TeST"));
    }

    @Test
    public void testTransformWithSpecialCharacters() {
        assertEquals("#@!321", transformer.transform("123!@#"));
    }

    @Test
    public void testTransformWithEmptyString() {
        assertEquals("", transformer.transform(""));
    }

}