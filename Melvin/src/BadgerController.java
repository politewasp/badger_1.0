import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BadgerController {
    Debug debug = Debug.getInstance();
    Storage storage = Storage.load();
    WindowFrame windowFrame = new WindowFrame();

    public BadgerController(){
        windowFrame.createCatButton.addActionListener(CreateCatButtonListener);
        windowFrame.createGoalButton.addActionListener(CreateGoalButtonListener);
    }


    ActionListener CreateGoalButtonListener = e -> createGoal();

//    //class GoalSelectedListener implements MouseListener{
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            GoalView eventSource = (GoalView)e.getSource();
//            modifyGoal(eventSource.sourceGoal);
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) { }
//        @Override
//        public void mouseReleased(MouseEvent e) { }
//        @Override
//        public void mouseEntered(MouseEvent e) { }
//        @Override
//        public void mouseExited(MouseEvent e) { }
//    }

    ActionListener CreateCatButtonListener = e-> createCat();


    static class GoalSelectedListener implements MouseListener {
        Storage storage = Storage.load();
        @Override
        public void mouseClicked(MouseEvent e) {
            GoalViewPanel eventSource = (GoalViewPanel)e.getSource();
            Goal goal = eventSource.sourceGoal;
            GoalModifyPopup popup = new GoalModifyPopup(goal);
            if(popup.buttonChoice==JOptionPane.OK_OPTION){
                goal.setName(popup.goalNameField.getText());
                goal.setDescription(popup.goalDescField.getText());
                goal.setCategoryName(storage.getCategoryNames().get(popup.categoryPicker.getSelectedIndex()));
                //set isShort
                //set isGood
                //set start
                //set end
                //goal.setDayOfWeek(daySelector.getSelectedIndex());
            } else if(popup.buttonChoice==JOptionPane.CANCEL_OPTION){
                storage.delete(goal);
            }
            BadgerController.windowFrame.refresh();
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
}



