package pl.put.poznan.transformer.logic.decorators;
import pl.put.poznan.transformer.logic.TextTransformation;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.HashMap;

public class ShortCutterDecorator implements TextTransformation {
    /*
    Function shortens selected phrases
    Phrases and shortcuts are stored using HashMap
    Function is not case-sensitive
    Parameters:
        input(String) text provided by user
    Returns:
        input(String) transformed input
    */

    private final HashMap<String, String> shortcutsDict = new HashMap<>();

    private void setup(){
        shortcutsDict.put("na przykład", "np.");
        shortcutsDict.put("między innymi", "m.in.");
        shortcutsDict.put("i tym podobne", "itd.");
        shortcutsDict.put("profesor", "prof.");
        shortcutsDict.put("doktor", "dr");
        shortcutsDict.put("magister", "mgr");
        shortcutsDict.put("inżynier", "inż.");
    }
    @Override
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
