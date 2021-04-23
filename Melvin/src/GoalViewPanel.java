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

    JLabel logsLabel = new JLabel();
    Font logsFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 10);

    JLabel totalDaysLabel = new JLabel();
    JLabel currentDaysLabel = new JLabel();

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints con = new GridBagConstraints();
    /**
     * Constructs a JPanel with fields for the data
     * stored in a Goal
     */
    public GoalViewPanel(){
        setMaximumSize(new Dimension(1000,100));
        setPreferredSize(new Dimension(200,100));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5,10,5,10),
                BorderFactory.createLineBorder(Color.black, 3)
        ));

        JPanel nameAndCatPanel = new JPanel();
        nameAndCatPanel.add(nameLabel);
        nameLabel.setFont(nameFont);
        nameAndCatPanel.add(new JLabel(" in "));
        nameAndCatPanel.add(catLabel);
        catLabel.setFont(catFont);

        JPanel loggedPanel = new JPanel();
        loggedPanel.add(new JLabel("Logged "));
        loggedPanel.add(logsLabel);
        logsLabel.setFont(logsFont);
        loggedPanel.add(new JLabel(" times."));

        setLayout(layout);

        con.insets = new Insets(5, 5, 5, 5);
        con.anchor = GridBagConstraints.SOUTHWEST;
        con.gridx = 0;
        con.gridy = 0;
        add(nameAndCatPanel, con);
        con.gridy = 1;
        add(status, con);
        con.gridy = 2;
        add(loggedPanel, con);


//        setBackground(Color.MAGENTA);
    }

    /**
     * Sets the status message to be displayed on the Panel
     * @param statusMessage String message to be displayed
     */
    public void setStatus(String statusMessage){
        status.setText(statusMessage);
    }

    /**
     * Updates the number of times the goal has been logged
     * @param timesLogged Integer number of time the goal has been logged
     */
    public void setLogNum(Integer timesLogged){
        logsLabel.setText(timesLogged.toString());
    }

    public void setCurrentDays(Integer days){
        currentDaysLabel.setText("Day "+days);
    }
    public void setTotalDays(Integer days){
        totalDaysLabel.setText("/"+days);
    }

}