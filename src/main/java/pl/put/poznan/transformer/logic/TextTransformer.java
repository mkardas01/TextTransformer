package pl.put.poznan.transformer.logic;

import java.util.Arrays;
public class TextTransformer {

    private final String transforms;

    public TextTransformer(String[] transforms){
        this.transforms = Arrays.toString (transforms);
        /* todo -> 3 methods (upper, lower, capitalize).
        Explanation:
        as an input you are receiving an array of transformations need to be performed, as example:
        this.transforms = [lower, capitalize] so first you are performing lower and then capitalize,
        and after that returning the string. Note that input string could look like "This is input string"
        and assuming user wanted it capitalized the output should look like "This Is Input String"

        Types
            Input: String
            this.transforms: String[]
            Output: String
         */
    }
    public String transform(String text){
        // of course, normally it would do something based on the transforms
        return text.toUpperCase();
    }
}
