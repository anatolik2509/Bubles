/**
 * Created by 1 on 17.05.2017.
 */
public enum Weapon {
    Pistol(800,20,false,"Пистолет",0),
    Automat(250,15,false,"Автомат",50),
    Minigan(100,10,false,"Миниган",10),
    Shotgun(2000,10,true,"Дробовик",50),
    IMBOTRON(100,20,true,"Имботрон",1);


    private int Speed,Damage,rare;
    private boolean veer;
    private String name;

    Weapon(int Speed,int Damage,boolean veer,String name,int rare){
        this.Speed=Speed;
        this.Damage=Damage;
        this.veer=veer;
        this.name=name;
        this.rare=rare;
    }

    public int getRare() {
        return rare;
    }

    public int getSpeed() {
        return Speed;
    }

    public int getDamage() {
        return Damage;
    }

    public boolean isVeer() {
        return veer;
    }

    public String getName(){return name;}
}
