/**
 * Created by 1 on 17.05.2017.
 */
public class Bullet extends Entity{

    private double mx;
    private double my;
    private Entity owner;

    public Bullet(double x,double y,int damage,double mx,double my,Entity owner){
        super.setX(x);
        super.setY(y);
        super.setHP(1);
        this.mx=mx;
        this.my=my;
        super.setSpeed(10);
        super.setRadius(3);
        super.setDamage(damage);
        super.setBulletDamage(false);
        this.owner=owner;




    }
    public void draw(){
        Panel.drawBullet((int)super.getX(),(int)super.getY());

    }
    public void update(){

        move(-(int)(mx*super.getSpeed()),-(int)(my*super.getSpeed()));
        if(super.getX()<0||super.getX()>800||super.getY()<0||super.getY()>800){
            super.setLife(false);
        }
        for(Entity e:Game.entities){
            double x=e.getX()-super.getX();
            double y=e.getY()-super.getY();
            int r=(int)Math.sqrt(x*x+y*y);
            if(r<e.getRadius()+3&&e.isBulletDamage()&&e!=this&&e!=owner){

                super.setLife(false);
                this.Attack(e);
            }
        }
        if(isLife()) {
            move(-(mx * super.getSpeed()), -(my * super.getSpeed()));
            if (super.getX() < 0 || super.getX() > 800 || super.getY() < 0 || super.getY() > 800) {
                super.setLife(false);
            }
            for (Entity e : Game.entities) {
                double x = e.getX() - super.getX();

                double y = e.getY() - super.getY();
                double r = Math.sqrt(x * x + y * y);
                if (r < e.getRadius() + 3 && e.isBulletDamage() && e != this  && e!=owner) {

                    super.setLife(false);
                    this.Attack(e);

                }
            }
        }
        draw();
    }
}
