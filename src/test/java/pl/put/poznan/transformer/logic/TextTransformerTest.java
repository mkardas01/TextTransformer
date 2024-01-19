package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.decorators.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class TextTransformerTest {

    private TextTransformer textTransformer;
    private TextTransformation upperDecorator;
    private TextTransformation lowerDecorator;
    private TextTransformation capitalizeDecorator;

    private TextTransformation inverseDecorator;
    private TextTransformation shortCutExtenderDecorator;

    @BeforeEach
    void setUp(){
        upperDecorator = mock(UpperDecorator.class);
        lowerDecorator = mock(LowerDecorator.class);
        capitalizeDecorator = mock(CapitalizeDecorator.class);
        inverseDecorator = mock(InverseDecorator.class);
        shortCutExtenderDecorator = mock(ShortExtenderDecorator.class);
    }

    @Test
    void testTransform() throws IllegalAccessException, NoSuchFieldException {
        String[] transforms = {"upper", "lower", "capitalize", "inverse"};
        textTransformer = new TextTransformer(transforms);

        Field transformersField = TextTransformer.class.getDeclaredField("transformers");
        transformersField.setAccessible(true);
        transformersField.set(textTransformer, new TextTransformation[] {upperDecorator, lowerDecorator,
                capitalizeDecorator, inverseDecorator});

        when(upperDecorator.transform("test")).thenReturn("TEST");
        when(lowerDecorator.transform("TEST")).thenReturn("test");
        when(capitalizeDecorator.transform("test")).thenReturn("Test");
        when(inverseDecorator.transform("Test")).thenReturn("tseT");

        String result = textTransformer.transform("test");
        assertEquals("tseT", result);

        verify(upperDecorator).transform("test");
        verify(lowerDecorator).transform("TEST");
        verify(capitalizeDecorator).transform("test");
        verify(inverseDecorator).transform("Test");
    }
    @Test
    void testTransform1() throws IllegalAccessException, NoSuchFieldException {
        String[] transforms = {"extend"};
        textTransformer = new TextTransformer(transforms);

        Field transformersField = TextTransformer.class.getDeclaredField("transformers");
        transformersField.setAccessible(true);
        transformersField.set(textTransformer, new TextTransformation[] {shortCutExtenderDecorator});

        when(shortCutExtenderDecorator.transform("np.")).thenReturn("na przykład");

        String result = textTransformer.transform("np.");
        assertEquals("na przykład", result);

        verify(shortCutExtenderDecorator).transform("np.");
    }
}
