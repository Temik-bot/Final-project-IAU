package Finals;

import java.awt.*;
import java.util.Random;

public class MenuParticles extends GameObject{
    private Handler handler;
    Random r = new Random();
    private Color col;
    int dir = 0;

    public MenuParticles(int x, int y, ID id , Handler handler) {
        super(x, y, id);
        this.handler = handler;
        dir = r.nextInt(2);
        if(dir == 0){
            velX = 2;
            velY = 8;
        }else if(dir ==1){
            velX = 8;
            velY = 2;
        }

        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

    }

    @Override
    public void tick() {
        x +=velX;
        y += velY;
        if(y <=0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <=0 || x >= Game.WIDTH - 16) velX  *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.07f, handler));

    }
    public Rectangle getBounds(){
        return new Rectangle(x, y ,16, 16);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect(x, y, 16, 16);

    }
}
