package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorators.ShortExtenderDecorator;

import static org.junit.jupiter.api.Assertions.*;

class ShortExtenderTest {
    TextTransformer transformer;
    @BeforeEach
    public void init(){
        transformer = new TextTransformer (new String[]{"extend"});
    }
    @Test
    public void testCut1(){
        assertEquals(transformer.transform("Np."), "Na przykład");
    }

    @Test
    public void testCut2(){
        assertEquals(transformer.transform("M.in."), "Między innymi");
    }

    @Test
    public void testCut3(){
        assertEquals(transformer.transform("dr"), "doktor");
    }

    @Test
    public void testCut4(){
        assertEquals(transformer.transform("np."), "na przykład");
    }

    @Test
    public void testCutSentence1(){
        assertEquals(transformer.transform("Test Dr i np."), "Test Doktor i na przykład");
    }

    @Test
    public void testCutSentence2(){
        assertEquals(transformer.transform("test Dr i np."), "test Doktor i na przykład");
    }

    @Test
    public void testCutSentence3(){
        assertEquals(transformer.transform("tEST Inż. i inż. lub I Mgr"), "tEST Inżynier i inżynier lub I Magister");
    }

    @Test
    public void testCutBlank(){
        assertEquals(transformer.transform(""), "");
    }
}