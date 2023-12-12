package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShortCutterTest {

    ShortCutter cutter;
    @BeforeEach
    public void init(){
        cutter = new ShortCutter();
    }
    @Test
    public void testCut1(){
        assertEquals(cutter.transform("na przykład"), "np.");
    }

    @Test
    public void testCut2(){
        assertEquals(cutter.transform("między innymi"), "m.in.");
    }

    @Test
    public void testCut3(){
        assertEquals(cutter.transform("profesor"), "prof.");
    }

    @Test
    public void testCut4(){
        assertEquals(cutter.transform("inżynier"), "inż.");
    }

    @Test
    public void testCutSentence1(){
        assertEquals(cutter.transform("Test Doktor i na przykład"), "test dr i np.");
    }


    @Test
    public void testCutSentence2(){
        assertEquals(cutter.transform("Test Inżynier i inżynier lub INŻYNIER i MaGister"), "test inż. i inż. lub inż. i mgr");
    }

    @Test
    public void testCutBlank(){
        assertEquals(cutter.transform(""), "");
    }

}