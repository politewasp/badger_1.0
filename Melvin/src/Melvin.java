import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 *  <h1>Melvin</h1>
 *  Driver class and controller
 *  Written Using Java 15
 *  @author Maraiah Matson, William Muhlbach
 *  @version 2.1
 *  @since 2021-03-16
 */
final class Melvin{

    public static void main(String[] args) throws IOException {
        //Make Swing UI match the system UI if possible
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Storage storage = Storage.load();
        Debug debug = Debug.getInstance();
        new BadgerController();
        //StoragePlaceholder storage = new StoragePlaceholder(5);

        storage.close();
    }
}

