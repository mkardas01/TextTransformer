package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    /*Endpoint implementing text transformation
    Usage: localhost:8080/transform?transforms=A&text=B
    Where:
    A - transformation type: [upper, lower, capitalize]
    B - transformation text

    Return: Transformed text - string
     */
    @RequestMapping(value = "/transform", method = RequestMethod.GET)
    public String textTransform(@RequestParam(value="transforms", defaultValue="upper") String transforms,
                      @RequestParam(value="text", defaultValue="test")String text){

        // log the parameters
        logger.debug(text);
        logger.debug(transforms);

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    /*Endpoint for tests

    Usage: localhost:8080/test

    Return: "test ok"
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "test ok";
    }
}


