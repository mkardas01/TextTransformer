package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;
import java.util.Objects;

/**
 *  Function removes adjacent repeated characters in the input text
 *  Function is not case-sensitive
 *              @param  textToTransform (String) - Text provided by the user.
 *              @return  transformedText (String) - Transformed input.
 */

public class EliminateRepetitionDecorator implements TextTransformation {
    @Override
    public String transform(String textToTransform){

        // Split the input text into an array of words using space as a delimiter
        String[] textArray = textToTransform.split(" ");

        // Array to store indices that need to be delayed (i.e., duplicated words)
        int[] indexToDelay = new int[textArray.length];

        // Find indices to be delayed
        for (int i = 0; i < textArray.length - 1; i++) {
            // Check if the current word is equal to the next word
            if (Objects.equals(textArray[i], textArray[i + 1])) {
                // Mark the index of the next word to be delayed
                indexToDelay[i + 1] = 1;
            }
        }

        // Replace duplicated words with an empty string
        for (int i = 0; i < textArray.length; i++) {
            // Check if the current index needs to be delayed
            if (indexToDelay[i] == 1) {
                // Replace duplicated word with an empty string
                textArray[i] = "";
            }
        }

        // Join the array into a string, replace multiple spaces with a single space, and trim leading/trailing spaces
        String result = String.join(" ", textArray).replaceAll("\\s+", " ");
        return result.trim();
    }
}
