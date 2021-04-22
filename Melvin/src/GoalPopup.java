import javax.swing.*;

public abstract class GoalPopup extends JOptionPane{
    //Poltergeist. Scary.

    Goal inputGoal;
    Storage storage = Storage.load();
    int saved;

    JPanel paramDump = new JPanel();
    JTextField goalNameField;
    JTextArea goalDescField;
    JComboBox CategoryPicker;

}

class GoalModifyPopup extends GoalPopup{

    public GoalModifyPopup(Goal goal){
        Object[] options = {"Save Goal", "Cancel", "Delete Goal"};
        inputGoal = goal;
        CategoryPicker = new JComboBox(storage.getCategoryNames().toArray());


        goalNameField = new JTextField(goal.getName());
        goalDescField = new JTextArea(goal.getDescription());
        //radio short/long
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

        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        JComboBox daySelector = new JComboBox(daysOfTheWeek);

        paramDump.add(new JLabel("Name: "));
        paramDump.add(goalNameField);
        paramDump.add(new JLabel("Description: "));
        paramDump.add(goalDescField);
        paramDump.add(new JLabel("Reminder Day: "));
        paramDump.add(daySelector);

        int saved = showOptionDialog(null, paramDump, "Goal Creation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Cancel");
        if(saved==JOptionPane.OK_OPTION){
            goal.setName(goalNameField.getText());
            goal.setDescription(goalDescField.getText());
            goal.setCategoryName(storage.getCategoryNames().get(CategoryPicker.getSelectedIndex()));
            //set isShort
            //set isGood
            //set start
            //set end
            //goal.setDayOfWeek(daySelector.getSelectedIndex());
        }
        Window.load().refresh();
    }
}

class GoalCreatePopup extends GoalPopup{
    Goal newGoal;
    Object[] options = {"Save Goal", "Cancel"};
    public GoalCreatePopup(){
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        JComboBox daySelector = new JComboBox(daysOfTheWeek);

        paramDump.add(new JLabel("Name: "));
        paramDump.add(goalNameField);
        paramDump.add(new JLabel("Description: "));
        paramDump.add(goalDescField);
        paramDump.add(new JLabel("Reminder Day: "));
        paramDump.add(daySelector);

        int saved = showOptionDialog(null, paramDump, "Goal Creation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Cancel");

        newGoal.setName(goalNameField.getText());
        newGoal.setDescription(goalDescField.getText());
        newGoal.setCategoryName(storage.getCategoryNames().get(CategoryPicker.getSelectedIndex()));
        //set isShort
        //set isGood
        //set start
        //set end
        //goal.setDayOfWeek(daySelector.getSelectedIndex());

        Window.load().refresh();
    }
}