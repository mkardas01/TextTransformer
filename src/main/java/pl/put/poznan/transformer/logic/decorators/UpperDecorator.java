package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

/**
 * The function changes the case of letters to uppercase.
 *
 * Parameters:
 *   text (String) - Text provided by the user.
 * 
 * Returns:
 *   transformedText (String) - Transformed input with all letters in uppercase.
 */

public class UpperDecorator implements TextTransformation {

    //returns text with upper cases
    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}