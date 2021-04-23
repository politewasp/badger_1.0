import javax.swing.*;
import java.io.IOException;

/**
 *  <h1>Melvin</h1>
 *  Driver class and controller
 *  Written Using Java 15
 *  @author Maraiah Matson, William Muhlbach
 *  @version 2.1
 *  @since 2021-03-16
 */
final class Melvin{
    WindowFrame window = new WindowFrame();
    Storage storage = Storage.load();
    HomePanel home = new HomePanel();
    CalendarPanel cal = new CalendarPanel();
    Debug debug = Debug.getInstance();

    private Melvin(){
        window.addTab("Home", home);
        window.addTab("Calendar", cal);
        //do stuff to calendar if needed
        window.setVisible(true);
    }

    public void main(String[] args) throws IOException {

        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        //Make Swing UI match the system UI if possible
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(Goal g:storage.goals){
            GoalViewPanel v = new GoalViewPanel();
            v.nameLabel.setText(g.getName());
            v.catLabel.setText(g.getCategoryName());
            //logic to ascertain if a goal is logged and the apply the proper message to status.
            home.goalListPanel.add(v);
            v.addMouseListener();
        }

        //StoragePlaceholder storage = new StoragePlaceholder(5);
        Storage storage = Storage.load();
        Goal test = new Goal();
        test.setName("test");
        //test.setStart("2021-03-24");
        //test.setEnd("2021-03-31");
        //test.setFrequency(1);
        test.setMessage("i exist");
        test.setDescription("test of data");
        debug.print(test.toString());
        storage.add(test);



        // storage test
        //Storage storage = new Storage();
        //storage.test();
        storage.close();


    }

    public void createCat(){
        CategoryCreationPopup popup = new CategoryCreationPopup();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            storage.add(new Category(popup.catNameField.getText()));
        }
        debug.print("\nbuttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }

    public void createGoal(){
        GoalCreationPopup popup = new GoalCreationPopup();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            storage.add(popup.newGoal);
        }
        debug.print("\nbuttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
        //windowFrame.refresh();
    }

    public void modifyGoal(Goal goal){
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
    }

}

