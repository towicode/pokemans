package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import controller.Engine;
/**
 * Defines a Keyboard. A keyboard listens for a keypressed event, and passes it to the engine. This tells the program where 
 * the player wants their trainer to move.
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class Keyboard extends KeyAdapter {

    private List<Integer> keysPressed = new ArrayList<Integer>();
    private final Engine engine;
    
    public Keyboard(final Engine engine) {
        this.engine = engine;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (!keysPressed.contains(e.getKeyCode())) {
            keysPressed.add(e.getKeyCode());
            engine.handleKeyboardInput(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed.remove((Object) e.getKeyCode());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public boolean isKeyPressed(int key) {
        return keysPressed.contains(key);
    }

}
