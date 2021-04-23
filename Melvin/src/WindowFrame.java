import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *  <h1>WindowFrame</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.0
 *  @since 2021-03-16
 */
public class WindowFrame extends JFrame {
    Debug debug = Debug.getInstance();

    JPanel bottomButtons = new JPanel();
    JButton createGoalButton = new JButton("+ Goal");
    JButton createCatButton = new JButton("+ Category");

    BorderLayout layout = new BorderLayout();

    Font buttonFont = new Font(new JLabel().getFont().getName(), Font.PLAIN, 20);
    Font titleFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 30);

    /**
     * constructs a JFrame with buttons for user interaction and
     * a center panel for displaying information to the user
     */
    public WindowFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");

        setLayout(layout);

        bottomButtons.add(createGoalButton);
        createGoalButton.setFont(buttonFont);

        bottomButtons.add(createCatButton);
        createCatButton.setFont(buttonFont);

        add(bottomButtons, BorderLayout.PAGE_END);

    }

    /**
     * Retrieves the createGoalButton to allow for the addition
     * of a listener
     * @return createGoalButton
     */
    public JButton getCreateGoalButton(){
        return createGoalButton;
    }

    /**
     * Retrieves the createCatButton to allow for the addition
     * of a listener
     * @return createCatButton
     */
    public JButton getCreateCatButton(){
        return createCatButton;
    }

    /**
     * Adds a Component to the center of the Frame
     * @param c Component to be added
     */
    public void addCenter(Component c){
        add(c, BorderLayout.CENTER);
    }
    public void removeCenter(){
        remove(layout.getLayoutComponent(BorderLayout.CENTER));
    }

//
//    public void refresh(){
//        invalidate();
//        //remove(layout.getLayoutComponent(BorderLayout.CENTER));
//        switch(currentState){
//            case "home"->openHome();
//            case "cal"->openCalendar();
//        }
//        validate();
//    }

}
