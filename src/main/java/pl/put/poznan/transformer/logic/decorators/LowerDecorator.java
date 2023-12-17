package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

public class LowerDecorator implements TextTransformation {
/**
 * The function changes the case of letters to lowercase.
 *
 * @param  text (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    //returns text with lower cases
    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}