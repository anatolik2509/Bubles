import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 1 on 17.05.2017.
 */
public class MouseMove extends MouseAdapter {
    public void mouseMoved(MouseEvent e) {
        double x=Game.player.getX()-e.getX();
        double y=Game.player.getY()-e.getY();
        double r=Math.sqrt(x*x+y*y);
        Game.player.setMx(x/r);
        Game.player.setMy(y/r);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x=Game.player.getX()-e.getX();
        double y=Game.player.getY()-e.getY();
        double r=Math.sqrt(x*x+y*y);
        Game.player.setMx(x/r);
        Game.player.setMy(y/r);
    }
}
