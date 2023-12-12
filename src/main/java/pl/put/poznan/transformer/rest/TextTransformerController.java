package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.Inverter;
import pl.put.poznan.transformer.logic.Numberer;
import pl.put.poznan.transformer.logic.ShortCutter;
import pl.put.poznan.transformer.logic.ShortExtender;
import pl.put.poznan.transformer.logic.transformers.TextTransformer;

import java.util.Arrays;
import java.util.Objects;


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    @RequestMapping(value = "/transform", method = RequestMethod.GET)
    /*Endpoint implementing text transformation
    Usage: localhost:8080/transform?transforms=A&text=B
    Where:
    A - transformation type: [upper, lower, capitalize]
    B - transformation text
    Note: In URL standard " " (space) is coded as %20, if you want text to me "Some text" code it
    in url as Some%20text

    Return: Transformed text - string
     */
    public String textTransform(@RequestParam(value="transforms", defaultValue="lower, capitalize") String[] transforms,
                                  @RequestParam(value="text", defaultValue="test")String text){


        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }


    @RequestMapping(value = "/inverse", method = RequestMethod.GET)
    /*Endpoint implementing text transformation
    Usage: localhost:8080/inverse?text=A
    Where:
    A - transformation text
    Note: In URL standard " " (space) is coded as %20, if you want text to me "Some text" code it
    in url as Some%20text

    Return: Transformed text - string
     */
    public String textInvert(@RequestParam(value="text", defaultValue="test")String text){

        // log the parameters
        logger.debug(text);

        Inverter inverter = new Inverter();
        return inverter.transform(text);
    }

    @RequestMapping(value = "/shortcut", method = RequestMethod.GET)
    /*Endpoint implementing text transformation
    Usage: localhost:8080/shortcut?type=A&text=B
    Where:
    A - when extend:  np. -> na przykład
        when shortcut:  na przykład -> np.
    B - transformation text
    Note: In URL standard " " (space) is coded as %20, if you want text to me "Some text" code it
    in url as Some%20text

    Return: Transformed text - string
     */
    public String textShortcut (@RequestParam(value="type", defaultValue="short, extend")String transforms,
                                @RequestParam(value="text", defaultValue="test")String text){

        // log the parameters
        logger.debug(text);

        if (Objects.equals(transforms, "short")){
            ShortCutter inverter = new ShortCutter();
            return inverter.transform(text);
        } else if (Objects.equals(transforms, "extend")) {
            ShortExtender inverter = new ShortExtender();
            return inverter.transform(text);

        }
        ShortCutter inverter = new ShortCutter();
        return inverter.transform(text);
    }


    @RequestMapping(value = "/number", method = RequestMethod.GET)
    /*Endpoint implementing text transformation
    Usage: localhost:8080/number?text=A
    Where:
    A - transformation text
    Note: In URL standard " " (space) is coded as %20, if you want text to me "Some text" code it
    in url as Some%20text

    Return: Transformed text - string
     */
    public String textNumber (@RequestParam(value="text", defaultValue="test")String text){

        // log the parameters
        logger.debug(text);

        Numberer numberer = new Numberer();
        return numberer.convert (text);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    /*Endpoint for tests
    Usage: localhost:8080/test
    Return: "test ok"
     */
    public String test(){
        return "test ok";
    }
}


