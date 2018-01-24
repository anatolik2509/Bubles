

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 1 on 16.05.2017.
 */
public class Panel extends JPanel {
    static String Time;
    static Panel game=new Panel();
    static boolean mousePressed=false;
    public Panel(){
        super();
        setFocusable(true);
        requestFocus();
        setLayout(new BorderLayout());
        setSize(800,800);
        addKeyListener(new Listeners());
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMove());


    }



    public static void addButton(JButton b){
        game.add(b);
    }

    public static void reset(){
        game.removeAll();
        game.update(game.getGraphics());



    }
    public static void drawPlayer(int x,int y){
        Graphics g=game.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(x-12,y-12,24,24);


    }
    public static void drawBullet(int x,int y){
        Graphics g=game.getGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(x-3,y-3,6,6);
    }
    public static void drawEnemy(int x,int y,int HP,int maxHP){
        Graphics g=game.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(x-12,y-12,24,24);
        double d=HP;
        d=d/maxHP;
        g.setColor(Color.BLACK);
        g.fillRect(x-10,y-14,20,2);
        g.setColor(Color.YELLOW);
        g.fillRect(x-10,y-14,(int)(d*20),2);
    }

    public static void drawBonus(int x,int y,Color c){
        Graphics g=game.getGraphics();
        g.setColor(c);
        g.fillRect(x-5,y-5,10,10);
    }
    public static void GameOver() {
        reset();
        game.setBackground(Color.BLACK);
        Graphics g=game.getGraphics();
        g.setColor(Color.WHITE);
        g.drawString("GameOver",350,400);
    }

    public static void drawText(int x,int y,String text){
        Graphics g=game.getGraphics();
        g.setColor(Color.BLACK);
        g.drawString(text,x-(text.length()/2)*7,y);
    }

    public static void drawExplosive(int x,int y,int radius){
        Graphics g=game.getGraphics();
        g.setColor(Color.WHITE);
        g.drawOval(x-radius,y-radius,radius*2,radius*2);
    }

}
