import javax.swing.*;

class HomePanel extends JPanel {
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    JPanel goalListPanel = new JPanel(layout);
    JScrollPane scrollPane = new JScrollPane(goalListPanel);
    public HomePanel(){
        setLayout(layout);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    public void addGoal(GoalViewPanel g){
        goalListPanel.add(g);
    }
}