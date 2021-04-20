import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.*;
import javax.swing.*;
import java.util.*;

public class GoalCreationPopup {
    JPanel parameterDump = new JPanel();

    JTextField goalNameField = new JTextField();
    JTextArea goalDescField = new JTextArea();
    //dropdown category
    //radio short/long
    //radio good/bad
    UtilDateModel startDate = new UtilDateModel();
    JDatePanelImpl startDatePanel = new JDatePanelImpl(startDate, new Properties());
    JDatePicker startDatePicker = new JDatePickerImpl(startDatePanel, new DateComponentFormatter());
    UtilDateModel endDate = new UtilDateModel();
    JDatePanelImpl endDatePanel = new JDatePanelImpl(startDate, new Properties());
    JDatePicker endDatePicker = new JDatePickerImpl(startDatePanel, new DateComponentFormatter());

    Object[] options = {"Create Goal", "Cancel"};

    public GoalCreationPopup(){
        int confirm = JOptionPane.showConfirmDialog(null, parameterDump, "Goal Creation", JOptionPane.OK_CANCEL_OPTION);
    }

}

