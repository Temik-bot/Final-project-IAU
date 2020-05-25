package Finals;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu){
            //play
            if(mouseOver(mx, my, 220, 100, 200, 64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemy();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }

            //Quit
            if(mouseOver(mx, my, 220, 300, 200, 64)){
                System.exit(1);
            }
        }
        //Help
        if(mouseOver(mx, my, 220, 200, 200, 64)){
            game.gameState = Game.STATE.Help;
        }
        //back button
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 220, 300, 200, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //try again button
        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 220, 300, 200, 64)){
                game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemy();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }
        }

    }

    public void mouseReleased(MouseEvent e) {
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y+ height) {
                return true;
            }else return false;
        }else return false;
    }

    public void tick(){

    }
    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("Times", 1, 40);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(220, 100, 200, 64);
            g.drawString("Start", 270, 150);

            g.drawRect(220, 200, 200, 64);
            g.drawString("Help", 270, 250);

            g.drawRect(220, 300, 200, 64);
            g.drawString("Quit", 270, 350);
        }else if(game.gameState == Game.STATE.Help){
            Font fnt3 = new Font("arial", 1, 20);
            Font fnt4 = new Font("Times", 1, 30);

            g.setFont(fnt3);
            g.setColor(Color.white);
            g.drawString("Use WASD keys to move and escape from enemies", 20, 70);

            g.setFont(fnt3);
            g.drawString("This Game was Made by T.Diusheev, so enjoy it ;)", 20, 200);

            g.setFont(fnt4);
            g.setColor(Color.red);
            g.drawRect(220, 300, 200, 75);
            g.drawString(">Back", 270, 350);
        }else if(game.gameState == Game.STATE.End){
            Font fnt3 = new Font("arial", 1, 50);
            Font fnt4 = new Font("Times", 1, 30);

            g.setFont(fnt3);
            g.setColor(Color.red);
            g.drawString("Game Over", 190, 100);

            g.setFont(fnt4);
            g.drawString("You Lost, Your Score is: " + hud.getScore(), 150, 200);

            g.setFont(fnt4);
            g.setColor(Color.GREEN);
            g.drawRect(220, 300, 200, 75);
            g.drawString("Try Again?", 240, 350);
        }

    }

}
