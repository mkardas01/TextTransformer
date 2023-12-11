package pl.put.poznan.transformer.logic;

import java.util.HashMap;

public class ShortExtender {
    /*
    Function extends shortcuts, provided by user
    Phrases and shortcuts are stored using HashMap
    Parameters:
        input(String) text provided by user
    Returns:
        input(String) transformed input
    */

    private final HashMap<String, String> shortcutsDict = new HashMap<>();

    private void setup(){
        shortcutsDict.put("np.", "na przykład");
        shortcutsDict.put("m.in.", "między innymi");
        shortcutsDict.put("itd.", "i tym podobne");
        shortcutsDict.put("prof.", "profesor");
        shortcutsDict.put("dr", "doktor");
        shortcutsDict.put("mgr", "magister");
    }

    public String transform(String input){
        this.setup();

        for (String key : this.shortcutsDict.keySet()){
            String shortcut = this.shortcutsDict.get(key);
            if (input.toLowerCase().contains(key)){
                input = input.toLowerCase().replace(key, shortcut);
            }
        }
        return input;
    }
}
