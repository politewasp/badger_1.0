import javax.swing.*;
import java.io.IOException;

/**
 *  <h1>Melvin</h1>
 *  Driver class
 *  Written Using Java 15
 *  @author Maraiah Matson, William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
final class Melvin{
    WindowFrame window = new WindowFrame();
    Storage storage = Storage.load();
    HomePanel home = new HomePanel();
    CalendarPanel cal = new CalendarPanel();
    private Melvin(){
        window.centerView.addTab("Home", home);
        window.centerView.addTab("Calendar", cal);
        //do stuff to calendar if needed
    }

    public void main(String[] args) throws IOException {
        Debug debug = Debug.getInstance();
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        //Make Swing UI match the system UI if possible
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(Goal g:storage.goals){
            GoalView v = new GoalView();
            v.nameLabel.setText(g.getName());
            v.catLabel.setText(g.getCategoryName());
            //logic to ascertain if a goal is logged and the apply the proper message to status.
            home.goalList.add(v);
            v.addMouseListener();
        }

        //StoragePlaceholder storage = new StoragePlaceholder(5);
        Storage storage = Storage.load();
        Goal test = new Goal();
        test.setName("test");
        //test.setStart("2021-03-24");
        //test.setEnd("2021-03-31");
        //test.setFrequency(1);
        test.setMessage("i exist");
        test.setDescription("test of data");
        debug.print(test.toString());
        storage.add(test);



        // storage test
        //Storage storage = new Storage();
        //storage.test();
        storage.close();

    }
}

