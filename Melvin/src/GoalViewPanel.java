import javax.swing.*;
import java.awt.*;
/**
 *  <h1>GoalViewPanel</h1>
 *  GUI Element
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.0
 *  @since 2021-03-16
 */
class GoalViewPanel extends JPanel {
    JLabel nameLabel = new JLabel();
    Font nameFont = new Font(new JLabel().getFont().getName(), Font.PLAIN, 20);

    JLabel catLabel = new JLabel();
    Font catFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 14);
    JLabel status = new JLabel();

    JLabel totalDaysLabel = new JLabel();
    JLabel currentDaysLabel = new JLabel();

    public GoalViewPanel(){
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
    }

    public void setStatus(String statusMessage){
        status.setText(statusMessage);
    }
    public void setCurrentDays(Integer days){
        currentDaysLabel.setText("Day "+days);
    }
    public void setTotalDays(Integer days){
        totalDaysLabel.setText("/"+days);
    }

}