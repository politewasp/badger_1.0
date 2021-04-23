import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 *  <h1>Window</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 2.0
 *  @since 2021-03-16
 */
public class WindowFrame extends JFrame {
    Debug debug = Debug.getInstance();
    JLabel title = new JLabel("", SwingConstants.CENTER);
    JTabbedPane centerView = new JTabbedPane();

    JPanel bottomButtons = new JPanel();
    JButton createGoalButton = new JButton("+ Goal");
    JButton createCatButton = new JButton("+ Category");

    BorderLayout layout = new BorderLayout();

    Font buttonFont = new Font(new JLabel().getFont().getName(), Font.PLAIN, 20);
    Font titleFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 30);

    public WindowFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");

        setLayout(layout);
        add(title, BorderLayout.PAGE_START);
        title.setFont(titleFont);

        bottomButtons.add(createGoalButton);
        createGoalButton.setFont(buttonFont);

        bottomButtons.add(createCatButton);
        createCatButton.setFont(buttonFont);

        add(bottomButtons, BorderLayout.PAGE_END);
    }
    public JButton getCreateGoalButton(){
        return createGoalButton;
    }
    public JButton getCreateCatButton(){
        return createCatButton;
    }
    public void addTab(String t, Component c){
        centerView.addTab(t, c);
    }
    public void setTitle(String t){
        title.setText(t);
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
