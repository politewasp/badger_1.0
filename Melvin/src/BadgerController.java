import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BadgerController {
    Storage storage = Storage.load();
    public BadgerController(){
    }
    public void createGoal(){
        GoalCreatePopup popup = new GoalCreatePopup();
        int buttonPushed = popup.launch();
        if(buttonPushed == JOptionPane.OK_OPTION){
            storage.add(popup.newGoal);
        }
        Window.load().refresh();
    }
    public void modifyGoal(Goal goal){

    }

}


class CreateButtonListener implements ActionListener {
    Debug debug = Debug.getInstance();
    Storage storage = Storage.load();
    @Override
    public void actionPerformed(ActionEvent e) {
        GoalCreatePopup popup = new GoalCreatePopup();
        popup.launch();
        if(popup.buttonChoice== JOptionPane.OK_OPTION){
            storage.add(popup.newGoal);
        }
        debug.print(popup.buttonChoice);
        debug.print("\nThis is a test\n");
        Window.load().refresh();
    }
}

class GoalSelectedListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        GoalView eventSource = (GoalView)e.getSource();
        Goal goal = eventSource.sourceGoal;
        GoalModifyPopup popup = new GoalModifyPopup(goal);
        Window.load().refresh();
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
