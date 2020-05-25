package Finals;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keyDownn = new boolean[4];
    Game game;

    public KeyInput(Handler handler, Game game){
        this.handler = handler;

        this.game = game;

        keyDownn[0] = false;
        keyDownn[1] = false;
        keyDownn[2] = false;
        keyDownn[3] = false;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject temObject = handler.object.get(i);
            if(temObject.getId() == ID.Player){
                //key events for Player 1
                if(key == KeyEvent.VK_W) { temObject.setVelY(-5); keyDownn[0] = true; }
                if(key == KeyEvent.VK_S) { temObject.setVelY(5); keyDownn[1] = true; }
                if(key == KeyEvent.VK_D) { temObject.setVelX(5); keyDownn[2] = true; }
                if(key == KeyEvent.VK_A) { temObject.setVelX(-5); keyDownn[3] = true; }
            }
        }
        if(key == KeyEvent.VK_P) {
            if (game.gameState == Game.STATE.Game)
            {
                if (Game.paused) Game.paused = false;
                else Game.paused = true;
            }
        }


        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject temObject = handler.object.get(i);
            if(temObject.getId() == ID.Player){
                //key events for Player 1
                if(key == KeyEvent.VK_W) keyDownn[0] = false;
                if(key == KeyEvent.VK_S) keyDownn[1] = false;
                if(key == KeyEvent.VK_D) keyDownn[2] = false;
                if(key == KeyEvent.VK_A) keyDownn[3] = false;

                if(!keyDownn[0] && !keyDownn[1]) temObject.setVelY(0);
                if(!keyDownn[2] && !keyDownn[3]) temObject.setVelX(0);
            }
        }

    }
}
