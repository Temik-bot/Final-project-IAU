package Finals;

import java.awt.*;

public class SuperEnemy extends GameObject{
    private Handler handler;

    public SuperEnemy(int x, int y, ID id ,Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 2;
        velY = 9;

    }

    @Override
    public void tick() {
        x +=velX;
        y += velY;
        if(y <=0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <=0 || x >= Game.WIDTH - 16) velX  *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.02f, handler));

    }
    public Rectangle getBounds(){
        return new Rectangle(x, y ,16, 16);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 16, 16);

    }
}
