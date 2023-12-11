package pl.put.poznan.transformer.logic.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLowerDecorator {
    private LowerDecorator lowerDecorator;

    @BeforeEach
    public void setUp(){
        lowerDecorator = new LowerDecorator();
    }

    @Test
    public void testIntTransform() {
        assertEquals("123", lowerDecorator.transform("123"));
    }

    @Test
    public void testLowerCaseTextTransform() {
        assertEquals("test test", lowerDecorator.transform("test test"));
    }

    @Test
    public void testUpperCaseTextTransform() {
        assertEquals("test test", lowerDecorator.transform("TEST TEST"));
    }

    @Test
    public void testCapitalizedTextTransform() {
        assertEquals("test test", lowerDecorator.transform("Test TesT"));
    }

    @Test
    public void testIntAndTextTransform() {
        assertEquals("test 1 test 2", lowerDecorator.transform("TEST 1 TEST 2"));
    }
}
