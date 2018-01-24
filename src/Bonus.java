/**
 * Created by 1 on 04.06.2017.
 */
import java.awt.*;
import java.util.Random;
public class Bonus {
    private int time=40000;
    private int bonusType;
    private int x;
    private int y;
    private Weapon bonusWeapon;

    public Bonus(int x,int y,int bonusType){
        this.x=x;
        this.y=y;
        this.bonusType=bonusType;
        Random r=new Random();
        if(bonusType==1) {
            int rand = 100;
            do{
                bonusWeapon = Weapon.values()[r.nextInt(Weapon.values().length)];
                rand=r.nextInt(100);
            }
            while (bonusWeapon.getRare() < rand) ;
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBonusType() {
        return bonusType;
    }

    public int getTime() {
        return time;
    }

    public void update(){
        time-=30;

        if(bonusType==0){
            Panel.drawBonus(x,y, Color.RED);
        }
        if(bonusType==1){
            Panel.drawBonus(x,y, Color.BLUE);
        }
        if(bonusType==2){
            Panel.drawBonus(x,y, Color.BLACK);
        }
        if(Math.sqrt((Game.player.getX()-x)*(Game.player.getX()-x)+(Game.player.getY()-y)*(Game.player.getY()-y))<17){
            this.peek();
        }
    }

    public void peek(){
        Random r=new Random();
        switch (bonusType){
            case 0: Game.player.setHP(Game.player.getHP()+5);
            if(Game.player.getHP()>Game.player.getMaxHP())Game.player.setHP(Game.player.getMaxHP());
                time=0;
            break;
            case 1:
                Panel.drawText(x,y,bonusWeapon.getName());
                if(Game.player.peek){
                Game.player.setWeapon(bonusWeapon);
                time=0;
            }
            break;
            case 2:Explosive e=new Explosive(x,y,150);
            e.addException(Game.player);
            Game.entities.add(e);
            time=0;
            break;
            default:break;
        }
    }

    public static final int Heal=0;
    public static final int weapon=1;
    public static final int Bomb=2;
}
