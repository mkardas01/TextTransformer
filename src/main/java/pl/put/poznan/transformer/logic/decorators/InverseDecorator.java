package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;


public class InverseDecorator implements TextTransformation {
/**
 * Function reverses the order of characters in the input text
 *             while preserving the case of letters at their original positions.
 * 
 *              @param  textToTransform (String) - Text provided by the user.
 *              @return  transformedText (String) - Transformed input.
 */

    @Override
    public String transform(String textToTransform){
        // Transform the input text into a character array
        char[] oldText = textToTransform.toCharArray();

        // Initialize a new array for the resulting text
        char[] newText = new char[oldText.length];

        // Iterate through the original text
        for (int i = 0; i < oldText.length; i++) {

            // Find the corresponding character in the original text (reverse order)
            char currentChar = oldText[oldText.length - 1 - i];

            // Check if the current character is a letter (%20 is a space character)
            if (Character.isLetter(oldText[i])) {

                // If it's a letter, keep the letters from the original text case-sensitive
                newText[i] = Character.isUpperCase(oldText[i]) ?
                        Character.toUpperCase(currentChar) : Character.toLowerCase(currentChar);
            } else {
                // If it's not a letter, preserve the character unchanged
                newText[i] = currentChar;
            }
        }
        // Return text after inversion
        return new String(newText);
    }


}
