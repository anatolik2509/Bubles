import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 1 on 16.05.2017.
 */
public class Game implements Runnable{
    static int SpawnSpeed;
    static int spawn;




    Thread thread=new Thread(this);
    public static int gameTime=0;
    static boolean exit=false;
    static boolean pause=false;
    static ArrayList<Entity> entities=new ArrayList<>();
    static ArrayList<Bonus> bonuses=new ArrayList<>();
    static Player player=new Player(400,400,500);
    public static void open(){
        Game g=new Game();

        StatusBar.add();
        entities.add(player);
        Color bg=new Color(102, 187, 255);
        Panel.game.setBackground(bg);
        g.thread.start();
        return;

    }
    @Override
    public void run() {

        int minute;
        int second;
        SpawnSpeed=8000;
        while(!exit){

                try {
                    thread.sleep(33);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(pause)continue;
                Panel.reset();
            Random random=new Random();
                if (spawn<=0){
                    spawn=SpawnSpeed;

                    int s=random.nextInt(8);
                    switch (s){
                        case 0:entities.add(new Enemy(-50,200));
                            break;
                        case 1:entities.add(new Enemy(-50,600));
                            break;
                        case 2:entities.add(new Enemy(200,-50));
                            break;
                        case 3:entities.add(new Enemy(600,-50));
                            break;
                        case 4:entities.add(new Enemy(850,200));
                            break;
                        case 5:entities.add(new Enemy(850,600));
                            break;
                        case 6:entities.add(new Enemy(200,850));
                            break;
                        case 7:entities.add(new Enemy(600,850));
                            break;
                    }
                }
                if(gameTime%3000==0){
                    int r=random.nextInt(100);
                    if(r>90)bonuses.add(new Bonus(random.nextInt(800),random.nextInt(800),1));
                    else if(r>80) bonuses.add(new Bonus(random.nextInt(800),random.nextInt(800),2));
                    else bonuses.add(new Bonus(random.nextInt(800),random.nextInt(800),0));
                }
                for(int i=0;i<entities.size();i++){
                    entities.get(i).update();
                     if (!entities.get(i).isLife()){
                        entities.remove(i);
                    }
                }

                for(int i=0;i<bonuses.size();i++){
                    bonuses.get(i).update();
                    if(bonuses.get(i).getTime()<=0){
                        bonuses.remove(i);
                    }
                }

                spawn-=30;
                if(gameTime>30000){
                    SpawnSpeed=7000;
                }
                if(gameTime>60000){
                    SpawnSpeed=6000;
                }
                if(gameTime>120000){
                    SpawnSpeed=5000;
                }
                if(gameTime>180000){
                    SpawnSpeed=4000;
                }
                if(gameTime>270000){
                    SpawnSpeed=2000;
                }
                if(gameTime>360000){
                    SpawnSpeed=1000;
                }

                gameTime += 30;
                minute=gameTime / 60000;
                second=gameTime % 60000/1000;
                Panel.Time = (String.format("%s:%s",(minute<10?"0":"")+minute,(second<10?"0":"")+second));
                StatusBar.update();

                if(!player.isLife())exit=true;

        }
        Panel.GameOver();



    }
}
