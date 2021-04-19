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
    JButton createButton = new JButton("Create Goal");
    //GridLayout layout = new GridLayout(0,1,5,5);
    BorderLayout layout = new BorderLayout();
    StoragePlaceholder storage;

    //TODO once the storage system is complete, replace this
    public Window(StoragePlaceholder storage){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");
        setLayout(layout);
        this.storage=storage;
        setVisible(true);

        //default behavior is to open to home page
        this.openHome();
        //add(new HomeView(storage));
    }

    public void refresh(){
        invalidate();
        validate();
    }

    public void openHome(){
        //removeAll();
        JScrollPane scrollPane = new JScrollPane(new HomeView(storage));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        add(createButton, BorderLayout.PAGE_END);
        refresh();
    }

    public void openCalendar(){
        removeAll();
        add(new CalendarView(storage));
    }
}


//Probably gonna end up being super inefficient to read the goals from storage each time a new view is selected, but I can't think of anything better right now, so we're just gonna run with it
//might be slightly better to pass just the array instead of the whole storage obj
class HomeView extends JPanel{
    JLabel title = new JLabel("Home");
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    public HomeView(StoragePlaceholder storage){
        setLayout(layout);
        add(title);
        for(Goal g:storage.goals){
            add(new GoalView(g));
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
        setMaximumSize(new Dimension(1000,100));
        setPreferredSize(new Dimension(200,100));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(5,10,5,10),
            BorderFactory.createLineBorder(Color.black)
        ));

        add(goalName);
        goalName.setText(goal.getName());
        goalName.setFont(new Font(goalName.getFont().getName(), Font.PLAIN, 20));

        add(new JLabel("in category"));

        add(goalCat);
        goalCat.setText(goal.getCategoryName());
        goalCat.setFont(new Font(goalCat.getFont().getName(), Font.BOLD, 14));

        add(status);
        //Need a function that determines if a goal has been logged for the day
        status.setText("Not yet logged!");
    }
}
