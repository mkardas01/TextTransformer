package pl.put.poznan.transformer.logic.transformers;

public class UpperDecorator implements TextTransformation {

    //returns text with upper cases
    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}