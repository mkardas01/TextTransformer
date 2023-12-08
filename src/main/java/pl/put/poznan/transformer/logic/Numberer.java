package pl.put.poznan.transformer.logic;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

public class Numberer {
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
            " dziesięć",
            " dwadzieścia",
            " trzydzieści",
            " czterdzieści",
            " pięćdziesiąt",
            " sześćdziesiat",
            " siedemdziesiąt",
            " osiemdziesiąt",
            " dziewięćdziesiąt"
    };

    private static final String[] numNames = {
            "",
            " jeden",
            " dwa",
            " trzy",
            " cztery",
            " pięć",
            " sześć",
            " siedem",
            " osiem",
            " dziewięć",
            " dziesięć",
            " jedenaście",
            " dwanaście",
            " trzynaście",
            " czternaście",
            " szesnaście",
            " siedemnaście",
            " osiemnaście",
            " dziewiętnaście",
            " dwadzieścia"
    };
    public String convert(String input){
        String[] text = input.split(" ");
        for (String s : text) {
            String numberText = "";
            if (NumberUtils.isCreatable(s)) {
                int number = Integer.parseInt (s);
                if(number >= 1000) continue;
                numberText += hundredsNames[number/100];
                number %= 100;
                if(number<=20){
                    numberText += numNames[number-1];
                }
                else{
                    numberText += tensNames[number/10];
                    number %= 10;
                    numberText += numNames[number];
                }
                System.out.println (numberText);
                System.out.println (s);
                System.out.println ("=============");
            }
        }
        return "";
    };
}
