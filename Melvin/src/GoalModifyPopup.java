import javax.swing.*;

public class GoalModifyPopup extends JOptionPane{
    JPanel paramDump = new JPanel();
    Goal inputGoal;
    Storage storage = Storage.load();
    int saved;
    Object[] options = {"Save Goal", "Cancel"};


    public GoalModifyPopup(Goal goal){
        inputGoal = goal;
        JTextField goalNameField = new JTextField(goal.getName());
        JTextArea goalDescField = new JTextArea(goal.getDescription());
        //JComboBox CategoryPicker = new JComboBox(storage.getCategoryNames());

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

        int saved = showOptionDialog(null, paramDump, "Goal Creation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Cancel");
        if(saved==JOptionPane.OK_OPTION){
            goal.setName(goalNameField.getText());
            goal.setDescription(goalDescField.getText());
            //goal.setCategoryName(Storage.getCategoryNames(CategoryPicker.getSelectedIndex()));
            //set isShort
            //set isGood
            //set start
            //set end
            //set day of week
        }
        Window.load().refresh();
    }
}