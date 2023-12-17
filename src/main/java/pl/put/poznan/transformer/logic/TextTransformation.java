package pl.put.poznan.transformer.logic;



//interface for text transformations
public interface TextTransformation {
/**
 * This interface defines the contract for text transformation decorators.
 * 
 * @param  text (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    String transform(String text);
}