package pl.put.poznan.transformer.logic.decorators;
import org.apache.commons.lang3.math.NumberUtils;
import pl.put.poznan.transformer.logic.TextTransformation;

import java.util.Arrays;
/**
 Function switching selected numeric value into words.
 works with every number, is converting every int up to 1000.
 Parameters:
 input(String) text provided by user
 Returns:
 input(String) transformed input
 */
public class NumbererDecorator implements TextTransformation {
    private static final String[] hundredsNames ={
            "",
            "sto",
            "dwieście",
            "trzysta",
            "czterysta",
            "pięćset",
            "sześćset",
            "siedemset",
            "osiemset",
            "dziewięćset"
    };
    private static final String[] tensNames = {
            "",
            "dziesięć",
            "dwadzieścia",
            "trzydzieści",
            "czterdzieści",
            "pięćdziesiąt",
            "sześćdziesiąt",
            "siedemdziesiąt",
            "osiemdziesiąt",
            "dziewięćdziesiąt"
    };

    private static final String[] numNames = {
            "",
            "jeden",
            "dwa",
            "trzy",
            "cztery",
            "pięć",
            "sześć",
            "siedem",
            "osiem",
            "dziewięć",
            "dziesięć",
            "jedenaście",
            "dwanaście",
            "trzynaście",
            "czternaście",
            "piętnaście",
            "szesnaście",
            "siedemnaście",
            "osiemnaście",
            "dziewiętnaście",
            "dwadzieścia"
    };

/**
 * The function converts numerical values into their corresponding word representations.
 *
 * @param  input (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    @Override
    public String transform(String input) {
        String[] text = input.split("\\s+");
        for (int i = 0; i < text.length; i++) {
            StringBuilder numberText = new StringBuilder();
            if (NumberUtils.isCreatable(text[i])) {
                int number = Integer.parseInt(text[i]);
                if (number >= 1000 || number < 0) continue;

                if (number == 0) {
                    numberText.append("zero");
                } else {
                    if (number >= 100) {
                        numberText.append(hundredsNames[number / 100]);
                        number %= 100;
                    }

                    if (number > 0) {
                        if (numberText.length() > 0) {
                            numberText.append(" ");
                        }

                        if (number <= 20) {
                            numberText.append(numNames[number]); // Use direct index
                        } else {
                            numberText.append(tensNames[number / 10]);
                            number %= 10;
                            if (number > 0) {
                                numberText.append(" ").append(numNames[number]); // Use direct index
                            }
                        }
                    }
                }
                text[i] = numberText.toString();
            }
        }

        return String.join(" ", Arrays.stream(text).filter(s -> !s.isEmpty()).toArray(String[]::new)).trim();
    }


}
