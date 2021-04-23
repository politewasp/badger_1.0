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



    //GridLayout layout = new GridLayout(0,1,5,5);
    BorderLayout layout = new BorderLayout();
    Storage storage;
    String currentState;

    Font buttonFont = new Font(new JLabel().getFont().getName(), Font.PLAIN, 20);
    Font titleFont = new Font(new JLabel().getFont().getName(), Font.BOLD, 30);

    public WindowFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");
        storage=Storage.load();

        setLayout(layout);
        add(title, BorderLayout.PAGE_START);
        title.setFont(titleFont);

        bottomButtons.add(createGoalButton);
        createGoalButton.setFont(buttonFont);

        bottomButtons.add(createCatButton);
        createCatButton.setFont(buttonFont);

        add(bottomButtons, BorderLayout.PAGE_END);

//        setVisible(true);
//        add(new JPanel());
        //default behavior is to open to home page
//        openHome();
    }

//    public void openHome(){
//        remove(layout.getLayoutComponent(BorderLayout.CENTER));
//        Collections.sort(storage.goals);
//        currentState = "home";
//        JScrollPane scrollPane = new JScrollPane(new HomePage());
//        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        add(scrollPane, BorderLayout.CENTER);
//        title.setText("Home");
//    }
//
//    public void openCalendar(){
//        remove(layout.getLayoutComponent(BorderLayout.CENTER));
//        currentState = "cal";
//        add(new CalendarPage(), BorderLayout.CENTER);
//        title.setText("Calendar");
//    }
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
