package Finals;

import java.awt.*;

public class HUD {
    public static int Health = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;

    public void tick(){
        Health = Game.clamp(Health, 0 ,100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = Health*2;
        score++;
    }
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, greenValue,0));
        g.fillRect(15, 15, Health *2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Your score: " + score, 15, 64 );
        g.drawString("Your level: " + level, 15, 80 );
        g.drawString("Press 'p' to pause", 15, 96);
    }
    public void setScore(int score){
        this.score = score;

    }
    public int getScore(){
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
