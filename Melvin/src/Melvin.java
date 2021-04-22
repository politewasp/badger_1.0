import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;

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

        Goal test = new Goal();
        test.setName("test");
        Calendar start = Calendar.getInstance();
        start.set(2021, 4,1);
        Calendar end = Calendar.getInstance();
        end.set(2021,4,31);
        //test.setStart(start);
       // test.setEnd(end);
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test.setDaysOfWeek(test1);
        test.setMessage("i exist");
        test.setDescription("test of data");
        debug.print(test.toString());
        //GoalDate today = new GoalDate(2021,4,22);
        //System.out.println(today);
       System.out.println(test.getDaysOfWeek());
       System.out.println(test.getDaysBetween(2021,4,22));





        // storage test
        //Storage storage = new Storage();
        //storage.test();
        storage.close();

    }
}
