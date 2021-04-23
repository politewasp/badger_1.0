import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Collections;

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
    JPanel home = new JPanel();
    JScrollPane scrollPane;
    BoxLayout homeLayout = new BoxLayout(home, BoxLayout.Y_AXIS);
    Debug debug = Debug.getInstance();

    /**
     * BadgerController Constructor aggregates GUI elements
     * and populates them with information and listeners to
     * allow for interaction
     */
    public BadgerController() {
        window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                try {
                    storage.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

        window.getCreateCatButton().addActionListener(CreateCatButtonListener);
        window.getCreateGoalButton().addActionListener(CreateGoalButtonListener);
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = false;


        home.setLayout(homeLayout);
        populateHomePanel(home);
        scrollPane = new JScrollPane(home);

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        window.addCenter(scrollPane);
        window.setVisible(true);

    }
    ActionListener CreateCatButtonListener = e -> createCat();
    ActionListener CreateGoalButtonListener = e -> createGoal();

    /**
     * Used to refresh the screen when there is new data to display
     */
    public void refreshHome(){
        debug.print("Refresh called\n");
        window.invalidate();
        window.remove(window.layout.getLayoutComponent(BorderLayout.CENTER));
        Collections.sort(storage.goals);
        home = new JPanel();
        homeLayout = new BoxLayout(home, BoxLayout.Y_AXIS);
        home.setLayout(homeLayout);
        populateHomePanel(home);
        scrollPane = new JScrollPane(home);

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(scrollPane, BorderLayout.CENTER);
        window.validate();
    }

    /**
     * Summons a CategoryCreationPopup to add a new
     * Category object to Storage
     */
    public void createCat(){
        CategoryCreationPopup popup = new CategoryCreationPopup();
        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            storage.add(new Category(popup.catNameField.getText()));
        }
        debug.print("createCat: buttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }

    /**
     * Summons a GoalCreationPopup to add a new Goal
     * object to storage
     */
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

    /**
     * Summons a GoalModifyPopup to allow users to
     * edit the fields of a goal
     * @param goal Goal to be edited
     */
    public void modifyGoal(Goal goal){
        Storage storage = Storage.load();

        GoalModifyPopup popup = new GoalModifyPopup(goal.getName());
        popup.setFieldName(goal.getName());
        popup.setFieldCat(goal.getCategoryName());
        popup.setFieldDesc(goal.getDescription());
        popup.setFieldDays(goal.getDaysOfWeek());
        popup.launch();

        if(popup.buttonChoice==JOptionPane.OK_OPTION){
            goal.setName(popup.getFieldName());
            goal.setDescription(popup.getFieldDesc());
            goal.setCategoryName(popup.getFieldCat());
            goal.setDaysOfWeek(popup.getFieldDays());
        } else if(popup.buttonChoice==JOptionPane.CANCEL_OPTION){
            storage.delete(goal);
        }
        refreshHome();
        debug.print("modifyGoal: buttonChoice: ");
        debug.print(popup.buttonChoice);
        debug.print("\n");
    }

    /**
     * populates a JPanel with GoalViewPanels containing
     * all the goals in Storage
     * @param p JPanel to be populated
     */
    public void populateHomePanel(JPanel p){
        for (Goal g : storage.goals) {
            debug.print(g.getName());
            GoalViewPanel v = new GoalViewPanel();
            v.nameLabel.setText(g.getName());
            v.catLabel.setText(g.getCategoryName());
            //logic to ascertain if a goal is logged and the apply the proper message to status.
            v.setLogNum(g.getLogged());
            if(g.getCompleted()){
                v.setStatus("Goal completed today!😊");
            }else{
                v.setStatus("Goal not completed today!☹");
            }
            p.add(v);
            v.addMouseListener(new GoalClickedListener(g));
        }
    }

    class GoalClickedListener implements MouseListener {
        Goal sourceGoal;
        Object[] options = {"Log Goal", "Edit Goal", "Cancel"};
        public GoalClickedListener(Goal goal){
            sourceGoal=goal;
        }

        /**
         * Generates a popup prompting the user if they would
         * like to modify or log the clicked goal and then
         * performs the requested operation
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane goalMenu = new JOptionPane();
            int buttonChoice = goalMenu.showOptionDialog(null, "What would you like to do?","Goal Options", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Log Goal");
            if(buttonChoice==JOptionPane.YES_OPTION){
                sourceGoal.setCompleted(new GoalDate());
            }else if(buttonChoice==JOptionPane.NO_OPTION){
                modifyGoal(sourceGoal);
            }
            refreshHome();
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    }
}


