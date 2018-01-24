/**
 * Created by 1 on 16.05.2017.
 */
public class Entity {
    private int maxHP;
    private int HP;
    private int Damage;
    private double x;
    private double y;
    private int reloadTime;
    private int attackTime;
    private int Speed;
    private boolean life=true;
    private int radius;
    private boolean bulletDamage=true;

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public boolean isBulletDamage() {
        return bulletDamage;
    }

    public void setBulletDamage(boolean bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isLife() {
        return life;
    }
    public void update(){

    }
    public void setLife(boolean life) {
        this.life = life;
    }

    public int getAttackTime() {
        return attackTime;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public void setAttackTime(int attackTime) {
        this.attackTime = attackTime;
    }

    public void setReloadTime(int reloadTime) {
        this.reloadTime = reloadTime;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }


    public int getSpeed() {
        return Speed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHP() {
        return HP;
    }

    public int getDamage() {
        return Damage;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void Attack(Entity Enemy){
        Enemy.setHP(Enemy.getHP()-Damage);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double mx, double my){
        x+=mx;
        y+=my;
    }
}
