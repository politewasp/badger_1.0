import javax.swing.*;
import java.awt.*;

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
    JLabel daysLabel = new JLabel("Days of the Week:");
    JLabel catLabel = new JLabel("Category: ");
    JLabel startLabel = new JLabel("Start Date: ");
    JLabel endLabel = new JLabel("Enda Date: ");

    JTextField goalNameField = new JTextField(10);
    JTextArea goalDescField = new JTextArea(5, 10);
    JScrollPane descPane = new JScrollPane(goalDescField);
    String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    JComboBox daySelector = new JComboBox(daysOfTheWeek);
    JComboBox categoryPicker = new JComboBox(storage.getCategoryNames().toArray());

    public GoalPopup(){
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
        paramDump.add(descLabel, con);
        con.gridx = 1;
        paramDump.add(new JScrollPane(goalDescField), con);

        con.gridx = 0;
        con.gridy = 2;
        paramDump.add(catLabel, con);
        con.gridx = 1;
        paramDump.add(categoryPicker);

        con.gridx = 0;
        con.gridy = 3;
        paramDump.add(startLabel, con);
        con.gridx = 1;
        paramDump.add(new JLabel("Placeholder"));

        con.gridx = 0;
        con.gridy = 4;
        paramDump.add(endLabel, con);
        con.gridx = 1;
        paramDump.add(new JLabel("Placeholder"));

        con.gridx = 0;
        con.gridy = 5;
        paramDump.add(daysLabel);
        con.gridx = 1;
        paramDump.add(new JLabel("Placeholder"));
    }
}

class GoalModifyPopup extends GoalPopup{
    public GoalModifyPopup(Goal goal){
        Object[] options = {"Save Goal", "Cancel", "Delete Goal"};
        //inputGoal = goal;

        goalNameField.setText(goal.getName());
        goalDescField.setText(goal.getDescription());

//        paramDump.add(new JLabel("Name: "));
//        paramDump.add(goalNameField);
//        paramDump.add(new JLabel("Description: "));
//        paramDump.add(goalDescField);
//        paramDump.add(new JLabel("Reminder Day: "));
//        paramDump.add(daySelector);
//        paramDump.add(new JLabel("Category: "));
//        paramDump.add(categoryPicker);

        int saved = showOptionDialog(null, paramDump, "Edit a Goal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Cancel");
        if(saved==JOptionPane.OK_OPTION){
            goal.setName(goalNameField.getText());
            goal.setDescription(goalDescField.getText());
            goal.setCategoryName(storage.getCategoryNames().get(categoryPicker.getSelectedIndex()));
            //set isShort
            //set isGood
            //set start
            //set end
            //goal.setDayOfWeek(daySelector.getSelectedIndex());
        }
    }
}

class GoalCreatePopup extends GoalPopup{
    Goal newGoal = new Goal();
    Object[] options = {"Save Goal", "Cancel"};
    public GoalCreatePopup(){
//        paramDump.add(new JLabel("Name: "));
//        paramDump.add(goalNameField);
//        paramDump.add(new JLabel("Description: "));
//        paramDump.add(goalDescField);
//        paramDump.add(new JLabel("Reminder Day: "));
//        paramDump.add(daySelector);
//        paramDump.add(new JLabel("Category: "));
//        paramDump.add(categoryPicker);
    }
    int launch(){
        int buttonOption = showOptionDialog(null, paramDump, "Goal Creation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Cancel");
        newGoal.setName(goalNameField.getText());
        newGoal.setDescription(goalDescField.getText());
        newGoal.setCategoryName(storage.getCategoryNames().get(categoryPicker.getSelectedIndex()));
        //set start
        //set end
        //goal.setDayOfWeek(daySelector.getSelectedIndex());
        return buttonOption;
    }
}