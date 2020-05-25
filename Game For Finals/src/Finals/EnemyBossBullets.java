package Finals;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullets extends GameObject{
    private Handler handler;
    Random r = new Random();

    public EnemyBossBullets(int x, int y, ID id , Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y ,16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        //if(y <=0 || y >= Game.HEIGHT - 32) velY *= -1;
        //if(x <=0 || x >= Game.WIDTH - 96) velX  *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler));

        if(y>=Game.HEIGHT) handler.removeObject(this);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int)x, (int)y, 16, 16);

    }
}
