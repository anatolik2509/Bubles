import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1 on 16.05.2017.
 */
public class Menu {
    public static void open(){

        JButton startButton=new JButton("Start");
        startButton.setLocation(200,350);
        startButton.setSize(400,100);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.reset();
                Game.open();
            }
        });
        Panel.addButton(startButton);

    }
}
