import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  <h1>GoalPopup</h1>
 *  Controller Element
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.3
 *  @since 2021-04-04
 */

public abstract class GoalPopup extends JOptionPane{
    //Poltergeist. Scary.
    Goal inputGoal;
    Storage storage = Storage.load();
    int buttonChoice;
    //radio good/bad

    /*
        Calendar testCal = Calendar.getInstance();
        CalendarDateModel startDate = new CalendarDateModel(testCal);
        JDatePanelImpl startDatePanel = new JDatePanelImpl(startDate, new Properties());
        JDatePicker startDatePicker = new JDatePickerImpl(startDatePanel, new DateComponentFormatter());
        UtilDateModel endDate = new UtilDateModel();
        JDatePanelImpl endDatePanel = new JDatePanelImpl(startDate, new Properties());
        JDatePicker endDatePicker = new JDatePickerImpl(startDatePanel, new DateComponentFormatter());
    */

    JPanel paramDump = new JPanel(new GridBagLayout());

    JLabel nameLabel = new JLabel("Name: ");
    JLabel descLabel = new JLabel("Description: ");
    JLabel catLabel = new JLabel("Category: ");

    JLabel startLabel = new JLabel("Start Date: ");
    JLabel endLabel = new JLabel("End Date: ");
    JLabel daysLabel = new JLabel("Days of the Week:");

    JCheckBox checkMon = new JCheckBox();
    JCheckBox checkTue = new JCheckBox();
    JCheckBox checkWed = new JCheckBox();
    JCheckBox checkThu = new JCheckBox();
    JCheckBox checkFri = new JCheckBox();
    JCheckBox checkSat = new JCheckBox();
    JCheckBox checkSun = new JCheckBox();
    JCheckBox[] daysOfTheWeek = {checkMon, checkTue, checkWed, checkThu, checkFri, checkSat, checkSun};

    JPanel daySelector = new JPanel();
//    String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    JTextField goalNameField = new JTextField(15);
    JTextArea goalDescField = new JTextArea(5, 15);
    JScrollPane descPane = new JScrollPane(goalDescField);


    JComboBox categoryPicker = new JComboBox(storage.getCategoryNames().toArray());

    /**
     * Constructs a Popup with a Panel containing user-editable
     * fields for Goal data
     */
    public GoalPopup(){
        daySelector.setLayout(new GridLayout(2, 7));
        for(Character c:"MTWTFSS".toCharArray()){
            daySelector.add(new JLabel(c.toString()));
        }
        daySelector.add(checkMon);
        daySelector.add(checkTue);
        daySelector.add(checkWed);
        daySelector.add(checkThu);
        daySelector.add(checkFri);
        daySelector.add(checkSat);
        daySelector.add(checkSun);

        goalDescField.setFont(new JLabel().getFont());
        goalDescField.setLineWrap(true);
        goalDescField.setWrapStyleWord(true);

        descPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.NORTHWEST;
        con.insets = new Insets(5, 5, 5, 5);

        con.gridx = 0;
        con.gridy = 0;
        paramDump.add(nameLabel, con);
        con.gridx = 1;
        paramDump.add(goalNameField, con);

        con.gridx = 0;
        con.gridy = 1;
        paramDump.add(catLabel, con);
        con.gridx = 1;

        paramDump.add(categoryPicker, con);
        con.gridx = 0;
        con.gridy = 2;
        paramDump.add(descLabel, con);
        con.gridx = 1;
        paramDump.add(new JScrollPane(goalDescField), con);

//        con.gridx = 2;
//        con.gridy = 0;
//        paramDump.add(startLabel, con);
//        con.gridx = 3;
//        paramDump.add(new JLabel("Placeholder"), con);
//
//        con.gridx = 2;
//        con.gridy = 1;
//        paramDump.add(endLabel, con);
//        con.gridx = 3;
//        paramDump.add(new JLabel("Placeholder"), con);

        con.gridx = 2;
        con.gridy = 2;
        paramDump.add(daysLabel, con);
        con.gridx = 3;
        paramDump.add(daySelector, con);
    }

    /**
     * Retrieves array of days of the week
     * @return boolean[] array containing info about which days the goal is to be logged on
     */
    public boolean[] getFieldDays(){
        boolean[] bArray = {checkMon.isSelected(), checkTue.isSelected(), checkWed.isSelected(), checkThu.isSelected(), checkFri.isSelected(), checkSat.isSelected(), checkSun.isSelected()};
        return bArray;
    }

    /**
     * Returns the text entered in the Name field
     * @return String name text
     */
    public String getFieldName(){
        return goalNameField.getText();
    }

    /**
     * Returns the category selected by the user
     * @return String category name
     */
    public String getFieldCat(){
        return storage.getCategoryNames().get(categoryPicker.getSelectedIndex());
    }

    /**
     * Returns the text entered in the Description field
     * @return String description text
     */
    public String getFieldDesc(){
        return goalDescField.getText();
    }

}

/**
 * Specialized GoalPopup for modifying a Goal
 */
class GoalModifyPopup extends GoalPopup{
    /**
     * populates the fields of a standard GoalPopup with the
     * data from the supplied Goal object
     * @param goalName String name of goal to be modified
     */
    String goalTitleName;
    Object[] options = {"Save Goal", "Cancel", "Delete Goal"};
    public GoalModifyPopup(String goalName){
        goalTitleName=goalName;
        //inputGoal = goal;

    }
    public void launch(){
        buttonChoice = showOptionDialog(null, paramDump, "Editing goal: "+goalTitleName, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Save Goal");
    }
    public void setFieldName(String goalName){
        goalNameField.setText(goalName);
    }
    public void setFieldDesc(String goalDesc){
        goalDescField.setText(goalDesc);
    }
    public void setFieldCat(String goalCat){
        categoryPicker.setSelectedItem(goalCat);
    }
    public void setFieldDays(boolean[] bArray){
        checkMon.setSelected(bArray[0]);
        checkTue.setSelected(bArray[1]);
        checkWed.setSelected(bArray[2]);
        checkThu.setSelected(bArray[3]);
        checkFri.setSelected(bArray[4]);
        checkSat.setSelected(bArray[5]);
        checkSun.setSelected(bArray[6]);
    }
}

/**
 * Specialized GoalPopup for the creation of a new Goal object
 */
class GoalCreationPopup extends GoalPopup{
    Goal newGoal = new Goal();
    Object[] options = {"Save Goal", "Cancel"};

    /**
     * Creates and summons a GoalPopup, then passes the user entered
     * information into a Goal object
     */
    public GoalCreationPopup(){
        buttonChoice = showOptionDialog(null, paramDump, "Goal Creation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Save Goal");
        newGoal.setName(goalNameField.getText());
        newGoal.setDescription(goalDescField.getText());
        newGoal.setCategoryName(storage.getCategoryNames().get(categoryPicker.getSelectedIndex()));
        //set start
        //set end
        //goal.setDayOfWeek(daySelector.getSelectedIndex());

    }
}