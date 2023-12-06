package pl.put.poznan.transformer.logic.transformers;

public class UpperDecorator implements TextTransformation {

    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}