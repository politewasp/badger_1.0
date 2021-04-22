import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  <h1>Melvin</h1>
 *  Driver class
 *  Written Using Java 15
 *  @author Maraiah Matson, William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
final class Melvin{
    private Melvin(){
        // adding this method prevents instantiation of Melvin elsewhere as a safeguard
    }


    public static void main(String[] args) throws IOException {
        // debug example
        Debug debug = Debug.getInstance();
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        //StoragePlaceholder storage = new StoragePlaceholder(5);
        Storage storage = Storage.load();

        Window.load();
        /*
        Goal test = new Goal();
        test.setName("test");
        //test.setStart("2021-03-24");
        //test.setEnd("2021-03-31");
        //test.setFrequency(1);
        test.setMessage("i exist");
        test.setDescription("test of data");
        debug.print(test.toString());
        */


        // storage test
        //Storage storage = new Storage();
        //storage.test();
        storage.close();

    }
}
