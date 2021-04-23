import javax.swing.*;

class HomePanel extends JPanel {

    JPanel goalListPanel = new JPanel();
    BoxLayout layout = new BoxLayout(goalListPanel, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(goalListPanel);
    public HomePanel(){
        goalListPanel.setLayout(layout);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    public void addGoal(GoalViewPanel g){
        goalListPanel.add(g);
    }
}