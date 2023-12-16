package pl.put.poznan.transformer.logic.decorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.*;

class EliminateRepetitionTest {
    TextTransformer transformer;
    @BeforeEach
    public void init(){
        transformer = new TextTransformer (new String[]{"repetition"});
    }
    @Test
    public void DobuleRepeat() {
        assertEquals("do", transformer.transform("do do"));
    }

    @Test
    public void TripleRepeat() {
        assertEquals("do", transformer.transform("do do do"));
    }

    @Test
    public void MixedRepeat() {
        assertEquals("do po", transformer.transform("do do po po"));
    }

    @Test
    public void MixedRepeatNotNextToEachOther() {
        assertEquals("do po do", transformer.transform("do do po do"));
    }

    @Test
    public void NotCaseSensitive() {
        assertEquals("do Do", transformer.transform("do Do"));
    }

    @Test
    public void UTF8() {
        assertEquals("dąb", transformer.transform("dąb dąb"));
    }

    @Test
    public void NotRepetition() {
        assertEquals("do po do po", transformer.transform("do po do po"));
    }

}