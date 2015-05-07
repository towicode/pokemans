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
   * GameWindow() Constructor for GameWindow class. Create the panel.
   */
  public GameWindow() {
    setLayout(null);
    setPreferredSize(new Dimension(250, 300));
    setMinimumSize(new Dimension(250, 250));
    JPanel Instructions = new JPanel();
    JLabel InstructionsLabel = new JLabel(
        "<html><body>Instructions: <br>Move with WASD or arrow keys <br>Open game menu with ENTER<br> Close menus with X <br>Ride bicycle with B (if you have it)</body></html>");
    Instructions.add(InstructionsLabel);

    this.gamePanel = new JPanel();
    this.gamePanel.setBounds(0, 0, 240, 180);
    Instructions.setBounds(0, 180, 240, 300);
    add(gamePanel);
    add(Instructions);
    // TODO add instructions on how to play
  }

}
