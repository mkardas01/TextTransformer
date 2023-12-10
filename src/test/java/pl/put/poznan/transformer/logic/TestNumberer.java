package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Numberer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumberer {
    Numberer numberer;
    @BeforeEach
    public void init(){
        numberer = new Numberer();
    }
    @Test
    public void testOneIntAndText() {
        assertEquals("Test jeden test test", numberer.convert("Test 1 test test"));
    }

    @Test
    public void testMultiplyIntAndText() {
        assertEquals("Test jeden test sto dwadzieścia trzy test dziewięćset osiemdziesiąt pięć", numberer.convert("Test 1 test 123 test 985"));
    }
    @Test
    public void testTextOnly() {
        assertEquals("Test test test", numberer.convert("Test test test"));
    }

    @Test
    public void testNumberGreater1000() {
        assertEquals("1111 test", numberer.convert("1111 test"));
    }
    @Test
    public void testNumberUnits() {
        assertEquals("siedem", numberer.convert("7"));
        assertEquals("jeden", numberer.convert("1"));
        assertEquals("dziewięć", numberer.convert("9"));


    }
    @Test
    public void testNumberTens() {
        assertEquals("dziesięć", numberer.convert("10"));
        assertEquals("jedenaście", numberer.convert("11"));
        assertEquals("trzynaście", numberer.convert("13"));
        assertEquals("piętnaście", numberer.convert("15"));
        assertEquals("dziewiętnaście", numberer.convert("19"));
    }
    @Test
    public void testNumberGreaterTwenty() {
        assertEquals("dwadzieścia", numberer.convert("20"));
        assertEquals("dwadzieścia dwa", numberer.convert("22"));
        assertEquals("sześćdziesiąt siedem", numberer.convert("67"));
        assertEquals("dziewięćdziesiąt dziewięć", numberer.convert("99"));
    }

    @Test
    public void testNumberHundreds() {
        assertEquals("sto dwadzieścia trzy", numberer.convert("123"));
        assertEquals("trzysta", numberer.convert("300"));
        assertEquals("pięćset dwa", numberer.convert("502"));
        assertEquals("siedemset dwanaście", numberer.convert("712"));
        assertEquals("dziewięćset pięćdziesiąt", numberer.convert("950"));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals("-7", numberer.convert("-7"));
        assertEquals("-22", numberer.convert("-22"));
    }
    @Test
    public void testWhitespace() {
        assertEquals("sto dwadzieścia trzy", numberer.convert(" 123 "));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("", numberer.convert(""));
    }
    @Test
    public void testSpecialCharacters() {
        // Modify the test based on your requirements
        assertEquals("test!", numberer.convert("test!"));
    }
}
