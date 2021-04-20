import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public abstract class Page extends JPanel {
    Storage storage = Storage.load();
}

class HomePage extends Page{
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    public HomePage(){
        setLayout(layout);
        ArrayList<Goal> goals = storage.goals;
        for(Goal g:goals){
            add(new GoalView(g));
        }
    }
}

class CalendarPage extends Page{
    JLabel labelM, labelY;
    JButton prevMonth, nextMonth;
    JTable calendarTable;


    public CalendarPage(){
        //uh, y'know... make a calendar i guess
    }
}


class GoalView extends Page{
    JLabel goalName = new JLabel();
    JLabel goalCat = new JLabel();
    JLabel status = new JLabel();
    Goal sourceGoal;

    //probs bad practice to have this listener defined within the the class
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            new GoalModifyPopup(sourceGoal);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };
    public GoalView(Goal goal){
        sourceGoal = goal;
        setMaximumSize(new Dimension(1000,100));
        setPreferredSize(new Dimension(200,100));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5,10,5,10),
                BorderFactory.createLineBorder(Color.black)
        ));

        add(goalName);
        goalName.setText(goal.getName());
        goalName.setFont(new Font("Arial", Font.PLAIN, 20));

        add(new JLabel("in category"));

        add(goalCat);
        goalCat.setText(goal.getCategoryName());
        goalCat.setFont(new Font("Arial", Font.BOLD, 14));

        add(status);
        //Need a function that determines if a goal has been logged for the day
        status.setText("Not yet logged!");
        addMouseListener(ml);
    }
}