package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorators.ShortCutterDecorator;


class ShortCutterTest {

    TextTransformer transformer;
    @BeforeEach
    public void init(){
        transformer = new TextTransformer (new String[]{"short"});
    }
    @Test
    public void testCut1(){
        assertEquals(transformer.transform("na przykład"), "np.");
    }

    @Test
    public void testCut2(){
        assertEquals(transformer.transform("między innymi"), "m.in.");
    }

    @Test
    public void testCut3(){
        assertEquals(transformer.transform("profesor"), "prof.");
    }

    @Test
    public void testCut4(){
        assertEquals(transformer.transform("inżynier"), "inż.");
    }

    @Test
    public void testCutSentence1(){
        assertEquals(transformer.transform("Test Doktor i na przykład"), "test dr i np.");
    }


    @Test
    public void testCutSentence2(){
        assertEquals(transformer.transform("Test Inżynier i inżynier lub INŻYNIER i MaGister"), "test inż. i inż. lub inż. i mgr");
    }

    @Test
    public void testCutBlank(){
        assertEquals(transformer.transform(""), "");
    }

}