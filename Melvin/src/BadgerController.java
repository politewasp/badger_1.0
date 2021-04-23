import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *  <h1>BadgerController</h1>
 *  Controller
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.2
 *  @since 2021-03-16
 */

public class BadgerController {

    WindowFrame window = new WindowFrame();
    Storage storage = Storage.load();
    HomePanel home = new HomePanel();

    JScrollPane homeScrollPane = new JScrollPane(home);

    CalendarPanel cal = new CalendarPanel();
    Debug debug = Debug.getInstance();
    public BadgerController() {

        window.getCreateCatButton().addActionListener(CreateCatButtonListener);
        window.getCreateGoalButton().addActionListener(CreateGoalButtonListener);
        //do stuff to calendar if needed
        window.setVisible(true);
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        populateHomePanel(home);


//        home.add(new JLabel("I'm Here!!!!"));

        homeScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        homeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.addTab("Home", home);
        window.addTab("Calendar", cal);

    }
    ActionListener CreateCatButtonListener = e -> createCat();
    ActionListener CreateGoalButtonListener = e -> createGoal();

    public void createCat(){
        CategoryCreationPopup popup = new CategoryCreationPopup();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            storage.add(new Category(popup.catNameField.getText()));
        }
        debug.print("createCat: buttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }
    public void createGoal(){
        GoalCreationPopup popup = new GoalCreationPopup();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            storage.add(popup.newGoal);
        }
        refreshHome();
        debug.print("createGoal: buttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }
    public void modifyGoal(Goal goal){
        GoalModifyPopup popup = new GoalModifyPopup(goal);
        Storage storage = Storage.load();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            goal.setName(popup.goalNameField.getText());
            goal.setDescription(popup.goalDescField.getText());
            goal.setCategoryName(storage.getCategoryNames().get(popup.categoryPicker.getSelectedIndex()));
            //set isGood
            //set start
            //set end
            //goal.setDayOfWeek(daySelector.getSelectedIndex());
        } else if(popup.buttonChoice==JOptionPane.CANCEL_OPTION){
            storage.delete(goal);
        }
        refreshHome();
        debug.print("modifyGoal: buttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }
    public void populateHomePanel(HomePanel p){
        for (Goal g : storage.goals) {
            debug.print(g.getName());
            GoalViewPanel v = new GoalViewPanel();
            v.nameLabel.setText(g.getName());
            v.catLabel.setText(g.getCategoryName());
            //logic to ascertain if a goal is logged and the apply the proper message to status.
            p.addGoalPanel(v);
            v.addMouseListener(new GoalClickedListener(g));
        }
    }
    public void refreshHome(){

    }
    class GoalClickedListener implements MouseListener {
        Goal sourceGoal;
        public GoalClickedListener(Goal goal){
            sourceGoal=goal;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //goalMenu
            modifyGoal(sourceGoal);

        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    }
}


