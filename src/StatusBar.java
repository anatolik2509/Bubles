

import javax.swing.*;
import java.awt.*;

/**
 * Created by 1 on 17.05.2017.
 */
public class StatusBar extends JPanel {
    static JLabel time=new JLabel();
    static StatusBar bar=new StatusBar();
    public StatusBar(){
        super();
        setPreferredSize(new Dimension(800,100));
        setLayout(new BorderLayout());
        setFocusable(true);
        requestFocus();
        add(time,BorderLayout.WEST);
    }
    public static void add(){
        Main.frame.add(bar,BorderLayout.SOUTH);
        bar.setBackground(Color.gray);
    }
    public static void drawTime(){
        time.setText(Panel.Time);

    }
    public static void update(){
        drawTime();
        Graphics g=bar.getGraphics();
        double d=Game.player.getHP();
        d=d/Game.player.getMaxHP();
        g.setColor(Color.BLACK);
        g.fillRect(200,70,400,20);
        g.setColor(Color.RED);
        g.fillRect(200,70,(int)(d*400),20);
    }

}
