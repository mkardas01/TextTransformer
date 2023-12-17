package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;


public class CapitalizeDecorator implements TextTransformation {
/**
 * The function capitalizes the first letter of each word while leaving the remaining letters in lowercase.
 *
 * @param  text (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    //returns capitalized text
    @Override
    public String transform(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            //for every word in text: first letter to upper, rest to lower case
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result.append(capitalizedWord).append(" ");
            }
        }
        return result.toString().trim();
    }
}