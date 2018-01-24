import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Math;

/**
 * Created by 1 on 17.05.2017.
 */
public class Mouse extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        Game.player.shooting=true;


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Game.player.shooting=false;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

}
