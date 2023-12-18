package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;


public class UpperDecorator implements TextTransformation {

/**
 * The function changes the case of letters to uppercase.
 *
 * @param  text (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    //returns text with upper cases
    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}