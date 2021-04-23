import javax.swing.*;

/**
 *  <h1>GoalCreationPopup</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 1
 *  @since 2021-04-16
 */
public class CategoryCreationPopup extends JOptionPane {
    JTextField catNameField = new JTextField(15);
    JLabel catLabel = new JLabel("Category Name: ");
    JPanel panel = new JPanel();
    Object[] options = {"Save Category","Cancel"};
    int buttonChoice;
    public CategoryCreationPopup(){
        panel.add(catLabel);
        panel.add(catNameField);
        buttonChoice = showOptionDialog(null,panel, "Create a new Category", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Save Category");
    }
}
