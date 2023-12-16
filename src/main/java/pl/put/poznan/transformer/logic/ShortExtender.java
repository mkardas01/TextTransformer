package pl.put.poznan.transformer.logic;

import java.util.HashMap;

/**
 Function extends shortcuts, provided by user
 Phrases and shortcuts are stored using HashMap
 Function is case-sensitive(on the first position)
 Parameters:
 input(String) text provided by user
 Returns:
 input(String) transformed input
 */


public class ShortExtender {

    private final HashMap<String, String> shortcutsDict = new HashMap<>();

    private void setup(){
        shortcutsDict.put("np.", "na przykład");
        shortcutsDict.put("m.in.", "między innymi");
        shortcutsDict.put("itd.", "i tym podobne");
        shortcutsDict.put("prof.", "profesor");
        shortcutsDict.put("dr", "doktor");
        shortcutsDict.put("mgr", "magister");
        shortcutsDict.put("inż.", "inżynier");

    }

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
