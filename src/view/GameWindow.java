package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * GameWindow extends JFrame
 * 
 * Defines the game window. The window has a screen for viewing the game, and
 * start, a, b, up, down, left, and right buttons for controlling the game if
 * the user doesn't want to use the keyboard.
 * 
 * @author Andrew Rickus
 * @author Todd Wickizer
 * @author Sean Gemberling
 * 
 *
 */
public class GameWindow extends JFrame {

  static final long serialVersionUID = 1L;
  public JPanel gamePanel;

  /**
   * GameWindow() 
   * Constructor for GameWindow class. Create the panel.
   */
  public GameWindow () {
    setLayout(null);
    setPreferredSize(new Dimension(250, 250));
    setMinimumSize(new Dimension(250, 250));

    this.gamePanel = new JPanel();
    this.gamePanel.setBounds(0, 0, 240, 180);
    add(gamePanel);
    
    //TODO add instructions on how to play
  }

}
