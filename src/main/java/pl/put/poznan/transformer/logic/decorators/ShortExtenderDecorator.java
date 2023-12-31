package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextTransformation;

import java.util.HashMap;



public class ShortExtenderDecorator implements TextTransformation {

    private final HashMap<String, String> shortcutsDict = new HashMap<>();

/**
 * Function set up the shortcuts map
 */
    private void setup(){
        shortcutsDict.put("np.", "na przykład");
        shortcutsDict.put("m.in.", "między innymi");
        shortcutsDict.put("itd.", "i tym podobne");
        shortcutsDict.put("prof.", "profesor");
        shortcutsDict.put("dr", "doktor");
        shortcutsDict.put("mgr", "magister");
        shortcutsDict.put("inż.", "inżynier");

    }
/**
 *  Function extends shortcuts, provided by user
 *  Phrases and shortcuts are stored using HashMap
 *  Function is case-sensitive(on the first position)
 * @param  input (String) - Text provided by the user.
 * @return  transformedText (String) - Transformed input.
 */
    public String transform(String input){
        if (input.isEmpty()){
            return input;
        }
        this.setup();
        String[] words = input.split("\\s+");
        StringBuilder convertedText = new StringBuilder();

        for (String word : words) {
            String correctedWord = word;
            String lowercaseWord = word.toLowerCase();

            if (shortcutsDict.containsKey(lowercaseWord)) {
                correctedWord = shortcutsDict.get(lowercaseWord);
            }
            if (Character.isUpperCase(word.charAt(0))) {
                correctedWord = toTitleCase(correctedWord);
            }
            convertedText.append(correctedWord).append(" ");
        }
        return convertedText.toString().trim();
    }

    private static String toTitleCase(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

}
