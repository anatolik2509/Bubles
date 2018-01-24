/**
 * Created by 1 on 17.05.2017.
 */
public class Enemy extends Entity{
    Enemy(int x,int y){
        setRadius(12);
        setX(x);
        setY(y);
        setHP(200);
        setMaxHP(200);
        setSpeed(3);
        setDamage(20);
        setAttackTime(1000);

    }
    public void update(){
        Panel.drawEnemy((int)super.getX(),(int)super.getY(),super.getHP(),super.getMaxHP());
        if(super.getHP()<=0)super.setLife(false);
        followPlayer();
    }

    public void followPlayer(){
        double x=Game.player.getX();
        double y=Game.player.getY();
        x=x-super.getX();
        y=y-super.getY();
        double degrees=Math.toDegrees(Math.atan2(y,x));
        move((Math.cos(Math.toRadians(degrees))*getSpeed()),(Math.sin(Math.toRadians(degrees))*getSpeed()));
        double r=Math.sqrt(x*x+y*y);
        if(r<Game.player.getRadius()+getRadius()&&getReloadTime()<=0){

            this.Attack(Game.player);
            setReloadTime(getAttackTime());
        }
        for (Entity e : Game.entities) {
            x = e.getX() - super.getX();
            y = e.getY() - super.getY();
            r = Math.sqrt(x * x + y * y);
            if (r < e.getRadius() + getRadius()) {

                r=r - (e.getRadius() + getRadius());
                degrees=Math.toDegrees(Math.atan2(y,x));
                move((Math.cos(Math.toRadians(degrees))*r/2),(Math.sin(Math.toRadians(degrees))*r/2));
                e.move(-(Math.cos(Math.toRadians(degrees))*r/2),-(Math.sin(Math.toRadians(degrees))*r/2));


            }
        }
        if(super.getReloadTime()>0)super.setReloadTime(super.getReloadTime()-30);
    }
}
