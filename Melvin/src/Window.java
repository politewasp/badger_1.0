import javax.swing.*;
import java.awt.*;
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
    //TODO temporary until we have a storage system
    static Goal[] goals = {new Goal("Goal 1"), new Goal("Goal 2"), new Goal("Goal 3")};

    public Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Badger");
        this.setLayout(layout);
        for(Goal g:goals){
            this.add(new goalView(g));
        }
        this.setVisible(true);

    }
}
class goalView extends JPanel{
    JLabel goalName = new JLabel();
    JLabel goalCat = new JLabel();
    JLabel status = new JLabel();

    //Eventually replace with constructor that builds panel from a goal
    public goalView(Goal goal){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(goalName);
        goalName.setText(goal.getName());
        goalName.setFont(new Font(goalName.getFont().getName(), Font.PLAIN, 20));
        this.add(new JLabel("in category"));
        this.add(goalCat);
        goalCat.setText(goal.getCategoryName());
        goalCat.setFont(new Font(goalCat.getFont().getName(), Font.BOLD, 14));
        this.add(status);
        status.setText("Not yet logged!");


    }
}
