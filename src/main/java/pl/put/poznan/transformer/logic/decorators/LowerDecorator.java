package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

public class LowerDecorator implements TextTransformation {

    //returns text with lower cases
    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}