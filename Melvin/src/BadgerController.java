import javax.swing.*;

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
    }
    public void modifyGoal(Goal goal){

    }

}
