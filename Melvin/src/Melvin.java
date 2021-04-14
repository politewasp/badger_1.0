import org.json.simple.parser.ParseException;

import java.io.IOException;

import javax.swing.*;

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
    public static void main(String[] args) {
        //TODO temporary until we have a storage system
        StoragePlaceholder storage = new StoragePlaceholder(5);
        Window mainWindow = new Window(storage);
        //literally have no clue as to how the window will update with the new goal, but we'll figure it out
        Goal test = new Goal();
        test.setName("test");
        test.setStart("2021-03-24");
        test.setEnd("2021-03-31");
        test.setFrequency(1);
        test.setMessage("i exist");
        //I feel like these function names are confusing
        //because there's no way to tell if setting true makes the Goal good or bad / short or long
        test.setGoodBad(true);
        test.setShortLong(true);
        test.setDescription("test of data");
        storage.add(test);
        mainWindow.refresh();

        System.out.println(test.toString());
        //storage.test();
    }
}
