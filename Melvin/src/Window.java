import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 *  <h1>Window</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
public class Window extends JFrame {
    Debug debug = Debug.getInstance();
    JButton createButton = new JButton("Create Goal");
    JButton homeButton = new JButton("Home");
    JButton calendarButton = new JButton("Calendar");
    JLabel title = new JLabel("", SwingConstants.CENTER);
    //GridLayout layout = new GridLayout(0,1,5,5);
    BorderLayout layout = new BorderLayout();
    Storage storage;
    String currentState;

    Font buttonFont = new Font("Arial", Font.PLAIN, 20);
    Font titleFont = new Font("Arial", Font.BOLD, 40);

    ActionListener calClicked = e -> openCalendar();

    ActionListener homeClicked = e -> openHome();

    private static Window single_instance = null;

    private Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");
        storage=Storage.load();

        setLayout(layout);
        add(title, BorderLayout.PAGE_START);
        title.setFont(titleFont);

        JPanel bottomButtons = new JPanel();
        add(bottomButtons, BorderLayout.PAGE_END);

        bottomButtons.add(calendarButton);
        calendarButton.setFont(buttonFont);
        calendarButton.addActionListener(calClicked);

        bottomButtons.add(homeButton);
        homeButton.setFont(buttonFont);
        homeButton.addActionListener(homeClicked);

        bottomButtons.add(createButton);
        createButton.setFont(buttonFont);
        createButton.addActionListener(new CreateButtonListener());

        setVisible(true);
        add(new JPanel());
        //default behavior is to open to home page
        openHome();
    }

    public void openHome(){
        remove(layout.getLayoutComponent(BorderLayout.CENTER));
        Collections.sort(storage.goals);
        currentState = "home";
        JScrollPane scrollPane = new JScrollPane(new HomePage());
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        title.setText("Home");
    }

    public void openCalendar(){
        remove(layout.getLayoutComponent(BorderLayout.CENTER));
        currentState = "cal";
        add(new CalendarPage(), BorderLayout.CENTER);
        title.setText("Calendar");
    }

    public void refresh(){
        invalidate();
        //remove(layout.getLayoutComponent(BorderLayout.CENTER));
        switch(currentState){
            case "home"->openHome();
            case "cal"->openCalendar();
        }
        validate();
    }

    public static Window load(){
        if(single_instance==null)
            single_instance=new Window();
        return single_instance;
    }
}
