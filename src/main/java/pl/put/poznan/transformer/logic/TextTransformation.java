package pl.put.poznan.transformer.logic;

/**
 * This interface defines the contract for text transformation decorators.
 *
 * Parameters:
 *   text (String) - Text provided by the user.
 *
 * Returns:
 *   transformedText (String) - Transformed input.
 */

//interface for text transformations
public interface TextTransformation {
    String transform(String text);
}