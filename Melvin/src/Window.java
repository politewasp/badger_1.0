import javax.swing.*;
import java.awt.*;

/**
 *  <h1>Window</h1>
 *  GUI Basis
 *  Written Using Java 15
 *  @author William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
public class Window extends JFrame{
    JButton createButton = new JButton("Create Goal");

    //GridLayout layout = new GridLayout(0,1,5,5);
    BorderLayout layout = new BorderLayout();
    Storage storage;

    //TODO once the storage system is complete, replace this
    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Badger");
        setLayout(layout);
        this.storage=Storage.load();
        setVisible(true);

        //default behavior is to open to home page
        this.openHome();
        //add(new HomeView(storage));
    }

    public void refresh(){
        invalidate();
        validate();
    }

    public void openHome(){
        //removeAll();
        JScrollPane scrollPane = new JScrollPane(new HomePage());
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        add(createButton, BorderLayout.PAGE_END);
        refresh();
    }

    public void openCalendar(){
        removeAll();
        add(new CalendarPage(storage.goals));
    }
}
