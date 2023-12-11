package pl.put.poznan.transformer.logic.transformers;

import java.util.Arrays;

public class TextTransformer implements TextTransformation {

    private final String transforms;
    private final TextTransformation[] transformers;

    public TextTransformer(String[] transforms) {
        this.transforms = Arrays.toString(transforms);
        this.transformers = initializeTransformers(transforms);
    }

    //initialize TextTransformation depends on transforms
    private TextTransformation[] initializeTransformers(String[] transforms) {
        TextTransformation[] transformers = new TextTransformation[transforms.length];
        for (int i = 0; i < transforms.length; i++) {
            switch (transforms[i]) {
                case "upper":
                    transformers[i] = new UpperDecorator();
                    break;
                case "lower":
                    transformers[i] = new LowerDecorator();
                    break;
                case "capitalize":
                    transformers[i] = new CapitalizeDecorator();
                    break;
            }
        }
        return transformers;
    }

    //every TextTransformations transforms text
    @Override
    public String transform(String text) {
        for (TextTransformation transformer : transformers) {
            text = transformer.transform(text);
        }
        //returns text after all transformations
        return text;
    }
}