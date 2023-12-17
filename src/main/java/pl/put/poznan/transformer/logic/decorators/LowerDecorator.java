package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

/**
 * The function changes the case of letters to lowercase.
 *
 * Parameters:
 *   text (String) - Text provided by the user.
 * 
 * Returns:
 *   transformedText (String) - Transformed input with all letters in lowercase.
 */

public class LowerDecorator implements TextTransformation {

    //returns text with lower cases
    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}