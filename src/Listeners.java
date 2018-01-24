import java.awt.event.*;

/**
 * Created by 1 on 16.05.2017.
 */
public class Listeners implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W) Game.player.up=true;
        if(e.getKeyCode()==KeyEvent.VK_A) Game.player.left=true;
        if(e.getKeyCode()==KeyEvent.VK_S) Game.player.down=true;
        if(e.getKeyCode()==KeyEvent.VK_D) Game.player.right=true;
        if(e.getKeyCode()==KeyEvent.VK_P) Game.pause=!Game.pause;
        if(e.getKeyCode()==KeyEvent.VK_E) Game.player.peek=true;


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W) Game.player.up=false;
        if(e.getKeyCode()==KeyEvent.VK_A) Game.player.left=false;
        if(e.getKeyCode()==KeyEvent.VK_S) Game.player.down=false;
        if(e.getKeyCode()==KeyEvent.VK_D) Game.player.right=false;
        if(e.getKeyCode()==KeyEvent.VK_E) Game.player.peek=false;


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
