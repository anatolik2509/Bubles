/**
 * Created by 1 on 16.05.2017.
 */
import java.lang.Math;
public class Player extends Entity {
    private double mx;
    private double my;
    public Weapon weapon;

    public boolean up=false;
    public boolean down=false;
    public boolean left=false;
    public boolean right=false;
    public boolean shooting=false;
    public boolean peek=false;
    public int money;

    public void setWeapon(Weapon w){
        super.setAttackTime(w.getSpeed());
        super.setDamage(w.getDamage());
        weapon=w;
        System.out.println("ok");
    }

    public double getMx() {
        return mx;
    }

    public double getMy() {
        return my;
    }

    public void setMx(double mx) {
        this.mx = mx;
    }

    public void setMy(double my) {
        this.my = my;
    }

    @Override
    public double getY() {
        return super.getY();
    }


    @Override
    public double getX() {
        return super.getX();
    }



    public Player(int x,int y,int HP){
        super.setX(x);
        super.setY(y);
        super.setMaxHP(HP);
        super.setHP(HP);
        super.setSpeed(5);

        super.setRadius(12);
        super.setBulletDamage(true);

        setWeapon(Weapon.Pistol);
    }

    public void update(){
        if(up) move(0,-super.getSpeed());
        if(down) move(0,super.getSpeed());
        if(left) move(-super.getSpeed(),0);
        if(right) move(super.getSpeed(),0);

        if(up&&left) move(-(Math.sin(45)*super.getSpeed())+super.getSpeed(),-(Math.sin(45)*super.getSpeed())+super.getSpeed());
        if(up&&right) move((Math.sin(45)*super.getSpeed())-super.getSpeed(),-(Math.sin(45)*super.getSpeed())+super.getSpeed());
        if(down&&left) move(-(Math.sin(45)*super.getSpeed())+super.getSpeed(),(Math.sin(45)*super.getSpeed())-super.getSpeed());
        if(down&&right) move((Math.sin(45)*super.getSpeed())-super.getSpeed(),(Math.sin(45)*super.getSpeed())-super.getSpeed());

        if(shooting&&super.getReloadTime()<=0){
            super.setReloadTime(super.getAttackTime());
            Game.entities.add(new Bullet(super.getX(),super.getY(),super.getDamage(),mx,my,this));
            if(weapon.isVeer()){
                int degrees=(int)Math.toDegrees(Math.atan2(my,mx));

                degrees-=30;
                degrees=(degrees<0)?360+degrees:degrees;
                for(int i=0;i<3;i++){
                    Game.entities.add(new Bullet(super.getX(),super.getY(),super.getDamage(),Math.cos(Math.toRadians(degrees)),Math.sin(Math.toRadians(degrees)),this));
                    degrees+=10;
                    degrees=(degrees>360)?degrees-360:degrees;

                }
                degrees+=10;
                degrees=(degrees>360)?degrees-360:degrees;
                for(int i=0;i<3;i++){
                    Game.entities.add(new Bullet(super.getX(),super.getY(),super.getDamage(),Math.cos(Math.toRadians(degrees)),Math.sin(Math.toRadians(degrees)),this));
                    degrees+=10;
                    degrees=(degrees>360)?degrees-360:degrees;

                }
            }

        }
        if(super.getReloadTime()>0)super.setReloadTime(super.getReloadTime()-30);
        if(getHP()<=0){
            setLife(false);
        }

        if(super.getX()<12) super.setX(12);
        if(super.getX()>773) super.setX(773);
        if(super.getY()<12) super.setY(12);
        if(super.getY()>700) super.setY(700);

        draw();
    }
    public void draw() {Panel.drawPlayer((int)this.getX(),(int)this.getY());}
}



