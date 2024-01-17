package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


/**
 *Controlling the Rest API
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TextTransformerController {


    /** Endpoint implementing text transformation
     *Usage: localhost:8080/transform?transforms=A&text=B
     *Where:
     *A - transformation type: [upper, lower, capitalize, inverse, short, extend, number]
     *B - transformation text
     *Note: In URL standard " " (space) is coded as %20, if you want text to me "Some text" code it
     *in url as Some%20text

     *Return: Transformed text - string
     */
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    @RequestMapping(value = "/transform", method = RequestMethod.GET)

    public String textTransform(@RequestParam(defaultValue="lower, capitalize") String[] transforms,
                                  @RequestParam(value="text", defaultValue="test")String text){
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
    /**Endpoint for tests
    *Usage: localhost:8080/test
    *Return: "test ok"
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "test ok";
    }
}


