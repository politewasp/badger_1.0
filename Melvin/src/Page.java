import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public abstract class Page extends JPanel {
    Storage storage = Storage.load();
}

class HomePanel extends JPanel{
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    JPanel goalList = new JPanel(layout);
    JScrollPane scrollPane = new JScrollPane(goalList);
    public HomePanel(){
        setLayout(layout);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
}

class CalendarPanel extends Page{
    JLabel labelM, labelY;
    JButton prevMonth, nextMonth;
    JTable calendarTable;


    public CalendarPanel(){
        //uh, y'know... make a calendar i guess
    }
}


class GoalView extends JPanel{
    JLabel nameLabel = new JLabel();
    Font nameFont = new Font(new JLabel().getFont().getName(), Font.PLAIN, 20);

    JLabel catLabel = new JLabel();
    Font catFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 14);
    JLabel status = new JLabel();

    public GoalView(){
        setMaximumSize(new Dimension(1000,100));
        setPreferredSize(new Dimension(200,100));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5,10,5,10),
                BorderFactory.createLineBorder(Color.black)
        ));

        add(nameLabel);
        nameLabel.setFont(nameFont);
        add(new JLabel(" in "));
        add(catLabel);
        catLabel.setFont(catFont);
        add(status);
        addMouseListener(new BadgerController.GoalSelectedListener());
    }

    public void setStatus(String statusMessage){
        status.setText(statusMessage);
    }

}