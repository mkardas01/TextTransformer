package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumberer {
    TextTransformer transformer;
    @BeforeEach
    public void init(){
        transformer = new TextTransformer (new String[]{"number"});
    }
    @Test
    public void testOneIntAndText() {
        assertEquals("Test jeden test test", transformer.transform("Test 1 test test"));
    }

    @Test
    public void testMultiplyIntAndText() {
        assertEquals("Test jeden test sto dwadzieścia trzy test dziewięćset osiemdziesiąt pięć", transformer.transform("Test 1 test 123 test 985"));
    }
    @Test
    public void testTextOnly() {
        assertEquals("Test test test", transformer.transform("Test test test"));
    }

    @Test
    public void testNumberGreater1000() {
        assertEquals("1111 test", transformer.transform("1111 test"));
    }
    @Test
    public void testNumberUnits() {
        assertEquals("siedem", transformer.transform("7"));
        assertEquals("jeden", transformer.transform("1"));
        assertEquals("dziewięć", transformer.transform("9"));


    }
    @Test
    public void testNumberTens() {
        assertEquals("dziesięć", transformer.transform("10"));
        assertEquals("jedenaście", transformer.transform("11"));
        assertEquals("trzynaście", transformer.transform("13"));
        assertEquals("piętnaście", transformer.transform("15"));
        assertEquals("dziewiętnaście", transformer.transform("19"));
    }
    @Test
    public void testNumberGreaterTwenty() {
        assertEquals("dwadzieścia", transformer.transform("20"));
        assertEquals("dwadzieścia dwa", transformer.transform("22"));
        assertEquals("sześćdziesiąt siedem", transformer.transform("67"));
        assertEquals("dziewięćdziesiąt dziewięć", transformer.transform("99"));
    }

    @Test
    public void testNumberHundreds() {
        assertEquals("sto dwadzieścia trzy", transformer.transform("123"));
        assertEquals("trzysta", transformer.transform("300"));
        assertEquals("pięćset dwa", transformer.transform("502"));
        assertEquals("siedemset dwanaście", transformer.transform("712"));
        assertEquals("dziewięćset pięćdziesiąt", transformer.transform("950"));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals("-7", transformer.transform("-7"));
        assertEquals("-22", transformer.transform("-22"));
    }
    @Test
    public void testWhitespace() {
        assertEquals("sto dwadzieścia trzy", transformer.transform(" 123 "));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("", transformer.transform(""));
    }
    @Test
    public void testSpecialCharacters() {
        // Modify the test based on your requirements
        assertEquals("test!", transformer.transform("test!"));
    }
}
