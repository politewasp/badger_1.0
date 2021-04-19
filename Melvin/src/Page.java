import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Page extends JPanel {
    Storage storage = Storage.load();
}


class HomeView extends Page{
    JLabel title = new JLabel("Home");
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    public HomeView(){
        setLayout(layout);
        add(title);
        ArrayList<Goal> goals = storage.goals;
        for(Goal g:goals){
            add(new GoalView(g));
        }
    }
}

class CalendarView extends Page{
    JLabel title = new JLabel("Calendar");
    JLabel labelM, labelY;
    JButton prevMonth, nextMonth;
    JTable calendarTable;


    public CalendarView(ArrayList<Goal> goals){
        this.add(title);
        //uh, y'know... make a calendar i guess
    }
}


class GoalView extends Page{
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