import javax.swing.*;
import java.awt.*;

/**
 * Created by 1 on 16.05.2017.
 */
public class Main {
    static JFrame frame;
    public static void main(String[] args) {
        frame=new JFrame();
        frame.setSize(800,850);
        frame.setTitle("Game");
        frame.setLayout(new BorderLayout());
        frame.add(Panel.game);
        frame.add(StatusBar.bar,BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Menu.open();

    }
}
