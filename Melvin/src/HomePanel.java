import javax.swing.*;
/**
 *  <h1>HomePanel</h1>
 *  GUI Element
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.0
 *  @since 2021-03-16
 */
class HomePanel extends JPanel {
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    public HomePanel(){
        this.setLayout(layout);
    }
    public void addGoalPanel(GoalViewPanel g){
        this.add(g);
    }
}