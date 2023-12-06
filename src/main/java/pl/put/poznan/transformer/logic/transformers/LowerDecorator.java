package pl.put.poznan.transformer.logic.transformers;

public class LowerDecorator implements TextTransformation {

    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}