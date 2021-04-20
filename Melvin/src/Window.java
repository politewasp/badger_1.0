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
    JLabel title = new JLabel("", SwingConstants.CENTER);
    //GridLayout layout = new GridLayout(0,1,5,5);
    BorderLayout layout = new BorderLayout();
    Storage storage;
    String currentState;

    ActionListener createClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Goal tempGoal = new Goal();
            GoalModifyPopup popup = new GoalModifyPopup(tempGoal);
            if(popup.saved==JOptionPane.OK_OPTION){
                storage.add(tempGoal);
            }
            debug.print(popup.saved);
            debug.print("\nThis is a test\n");
            refresh();
        }
    };

    private static Window single_instance = null;

    private Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");
        storage=Storage.load();

        setLayout(layout);
        add(title, BorderLayout.PAGE_START);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        add(createButton, BorderLayout.PAGE_END);
        createButton.setFont(new Font("Arial", Font.PLAIN, 20));
        createButton.addActionListener(createClicked);
        setVisible(true);

        //default behavior is to open to home page
        this.openHome();
        //add(new HomeView(storage));
    }

    public void openHome(){
        Collections.sort(storage.goals);
        //removeAll();
        currentState = "home";
        JScrollPane scrollPane = new JScrollPane(new HomePage());
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        title.setText("Home");
    }

    public void openCalendar(){
        //removeAll();
        currentState = "cal";
        add(new CalendarPage(), BorderLayout.CENTER);
    }

    public void refresh(){
        invalidate();
        remove(layout.getLayoutComponent(BorderLayout.CENTER));
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
