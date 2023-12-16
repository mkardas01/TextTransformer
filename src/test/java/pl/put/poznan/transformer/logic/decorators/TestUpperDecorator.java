package pl.put.poznan.transformer.logic.decorators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class TestUpperDecorator {

    private UpperDecorator upperDecorator;

    @BeforeEach
    public void setUp(){
        upperDecorator = new UpperDecorator();
    }

    @Test
    public void testIntTransform() {
        assertEquals("123", upperDecorator.transform("123"));
    }

    @Test
    public void testLowerCaseTextTransform() {
        assertEquals("TEST TEST", upperDecorator.transform("test test"));
    }

    @Test
    public void testUpperCaseTextTransform() {
        assertEquals("TEST TEST", upperDecorator.transform("TEST TEST"));
    }

    @Test
    public void testCapitalizedTextTransform() {
        assertEquals("TEST TEST", upperDecorator.transform("Test TesT"));
    }

    @Test
    public void testIntAndTextTransform() {
        assertEquals("TEST 1 TEST 2", upperDecorator.transform("test 1 test 2"));
    }
}
