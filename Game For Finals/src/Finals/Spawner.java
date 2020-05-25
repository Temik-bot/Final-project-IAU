package Finals;

import Finals.HUD;
import Finals.Handler;

import java.util.Random;

public class Spawner {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;

    }
    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 200){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if(hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 4){
                handler.addObject(new SuperEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SuperEnemy, handler));
            }else if(hud.getLevel() == 5){
            handler.addObject(new SuperEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SuperEnemy, handler));
            }else if(hud.getLevel() == 6){
                handler.addObject(new SuperEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SuperEnemy, handler));
            }else if(hud.getLevel() == 7){
                handler.addObject(new SuperEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SuperEnemy, handler));
            }else if(hud.getLevel() == 8){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));

            }else if(hud.getLevel() == 10) {
                handler.clearEnemy();
                handler.addObject(new BossEnemy(Game.WIDTH/2 - 48, -100, ID.BossEnemy, handler));
            }
        }
    }
}
