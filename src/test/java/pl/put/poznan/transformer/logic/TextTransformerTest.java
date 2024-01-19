package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorators.CapitalizeDecorator;
import pl.put.poznan.transformer.logic.decorators.LowerDecorator;
import pl.put.poznan.transformer.logic.decorators.UpperDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class TextTransformerTest {

    private TextTransformer textTransformer;
    private TextTransformation upperDecorator;
    private TextTransformation lowerDecorator;
    private TextTransformation capitalizeDecorator;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        upperDecorator = mock(UpperDecorator.class);
        lowerDecorator = mock(LowerDecorator.class);
        capitalizeDecorator = mock(CapitalizeDecorator.class);

        String[] transforms = {"upper", "lower", "capitalize"};
        textTransformer = new TextTransformer(transforms);

        Field transformersField = TextTransformer.class.getDeclaredField("transformers");
        transformersField.setAccessible(true);
        transformersField.set(textTransformer, new TextTransformation[] {upperDecorator, lowerDecorator, capitalizeDecorator});
    }

    @Test
    void testTransform() {
        when(upperDecorator.transform("test")).thenReturn("TEST");
        when(lowerDecorator.transform("TEST")).thenReturn("test");
        when(capitalizeDecorator.transform("test")).thenReturn("Test");

        String result = textTransformer.transform("test");
        assertEquals("Test", result);

        verify(upperDecorator).transform("test");
        verify(lowerDecorator).transform("TEST");
        verify(capitalizeDecorator).transform("test");
    }
}
