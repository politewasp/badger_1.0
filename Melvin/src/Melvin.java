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
        new Window();
        ArrayList<Integer> days = new ArrayList<>();
        days.add(0);
        days.add(6);
        Goal test = new Goal();
        test.setName("test");
        test.setStart("2021-03-24");
        test.setEnd("2021-03-31");
        test.setDaysOfWeek(days);
        test.setMessage("i exist");
        test.setGoodBad(true);
        test.setShortLong(true);
        test.setDescription("test of data");
        System.out.println(test.toString());

        // debug test
        Debug debug = Debug.getInstance();
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        // storage test
        Storage storage = new Storage();
        storage.test();
    }
}
