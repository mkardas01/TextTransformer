package pl.put.poznan.transformer.logic.decorators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCapitalizeDecorator {
    private CapitalizeDecorator capitalizeDecorator;

    @BeforeEach
    public void setUp(){
        capitalizeDecorator = new CapitalizeDecorator();
    }

    @Test
    public void testIntTransform() {
        assertEquals("123", capitalizeDecorator.transform("123"));
    }

    @Test
    public void testLowerCaseTextTransform() {
        assertEquals("Test Test", capitalizeDecorator.transform("test test"));
    }

    @Test
    public void testUpperCaseTextTransform() {
        assertEquals("Test Test", capitalizeDecorator.transform("TEST TEST"));
    }

    @Test
    public void testCapitalizedTextTransform() {
        assertEquals("Test Test", capitalizeDecorator.transform("Test TesT"));
    }

    @Test
    public void testIntAndTextTransform() {
        assertEquals("Test 1 Test 2", capitalizeDecorator.transform("TEST 1 TEST 2"));
    }
}
