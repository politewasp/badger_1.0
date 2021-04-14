import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 *  <h1>Window</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
public class Window extends JFrame{
    JButton createButton = new JButton("+");
    GridLayout layout = new GridLayout(0,1,5,5);
    StoragePlaceholder storage;

    //TODO once the storage system is complete, replace this
    public Window(StoragePlaceholder storage){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Badger");
        this.setLayout(layout);
        //default behavior is to open to home page
        this.openHome();

        this.setVisible(true);
    }

    public void refresh(){
        invalidate();
        validate();
    }

    public void openHome(){
        this.removeAll();
        this.add(new HomeView(storage));
    }

    public void openCalendar(){
        this.removeAll();
        this.add(new CalendarView(storage));
    }
}


//Probably gonna end up being super inefficient to read the goals from storage each time a new view is selected, but I can't think of anything better right now, so we're just gonna run with it
//might be slightly better to pass just the array instead of the whole storage obj
class HomeView extends JPanel{
    JLabel title = new JLabel("Home");
    GridLayout layout = new GridLayout(0,1,5,5);
    public HomeView(StoragePlaceholder storage){
        this.setLayout(layout);
        this.add(title);
        for(Goal g:storage.goals){
            this.add(new GoalView(g));
        }
    }
}

class CalendarView extends JPanel{
    JLabel title = new JLabel("Calendar");
    JLabel labelM, labelY;
    JButton prevMonth, nextMonth;
    JTable calendarTable;


    public CalendarView(StoragePlaceholder storage){
        this.add(title);
        //uh, y'know... make a calendar i guess
    }
}


class GoalView extends JPanel{
    JLabel goalName = new JLabel();
    JLabel goalCat = new JLabel();
    JLabel status = new JLabel();

    //Eventually replace with full constructor that builds panel from a goal
    public GoalView(Goal goal){
        this.setSize(600, 200);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(goalName);
        goalName.setText(goal.getName());
        goalName.setFont(new Font(goalName.getFont().getName(), Font.PLAIN, 20));
        this.add(new JLabel("in category"));
        this.add(goalCat);
        goalCat.setText(goal.getCategoryName());
        goalCat.setFont(new Font(goalCat.getFont().getName(), Font.BOLD, 14));
        this.add(status);
        //Need a function that determines if a goal has been logged for the day
        status.setText("Not yet logged!");


    }
}
