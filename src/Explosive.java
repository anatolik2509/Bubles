import java.util.ArrayList;

/**
 * Created by 1 on 05.06.2017.
 */
public class Explosive extends Entity{
    int radius=0;
    int maxRadius;
    private ArrayList<Entity> exceptedEntity=new ArrayList<>();
    public Explosive(int x,int y,int maxRadius){
        this.setX(x);
        this.setY(y);
        this.maxRadius=maxRadius;
        this.setHP(1);
        setDamage(50);
    }

    public void addException(Entity entity){
        exceptedEntity.add(entity);
    }

    public void update(){
        radius+=5;
        for(Entity e:Game.entities){
            if(Coordinate.lineLength(e.getX(),e.getY(),this.getX(),this.getY())<this.radius&&e!=this){
                boolean ex=true;
                for(Entity r:exceptedEntity)if(e==r&&e!=this)ex=false;
                if (ex) {
                    Attack(e);
                    e.move(10*Math.cos(Math.toRadians(Coordinate.degrees(e.getX(),e.getY(),this.getX(),this.getY()))),10*Math.sin(Math.toRadians(Coordinate.degrees(e.getX(),e.getY(),this.getX(),this.getY()))));
                    addException(e);
                }
            }
        }
        Panel.drawExplosive((int)getX(),(int)getY(),radius);
        if(radius>maxRadius)setLife(false);
    }
}
