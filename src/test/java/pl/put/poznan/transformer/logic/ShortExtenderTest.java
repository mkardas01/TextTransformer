package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortExtenderTest {
    ShortExtender extender;
    @BeforeEach
    public void init(){
        extender = new ShortExtender();
    }
    @Test
    public void testCut1(){
        assertEquals(extender.transform("Np."), "Na przykład");
    }

    @Test
    public void testCut2(){
        assertEquals(extender.transform("M.in."), "Między innymi");
    }

    @Test
    public void testCut3(){
        assertEquals(extender.transform("dr"), "doktor");
    }

    @Test
    public void testCut4(){
        assertEquals(extender.transform("np."), "na przykład");
    }

    @Test
    public void testCutSentence1(){
        assertEquals(extender.transform("Test Dr i np."), "Test Doktor i na przykład");
    }

    @Test
    public void testCutSentence2(){
        assertEquals(extender.transform("test Dr i np."), "test Doktor i na przykład");
    }

    @Test
    public void testCutSentence3(){
        assertEquals(extender.transform("tEST Inż. i inż. lub I Mgr"), "tEST Inżynier i inżynier lub I Magister");
    }

    @Test
    public void testCutBlank(){
        assertEquals(extender.transform(""), "");
    }
}