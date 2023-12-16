package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

public class UpperDecorator implements TextTransformation {

    //returns text with upper cases
    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}