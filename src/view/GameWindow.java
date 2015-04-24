package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * GameWindow extends JFrame
 * 
 * Defines the game window. The window has a screen for viewing the game, and start, a, b, up, down, left, and right buttons 
 * for controlling the game if the user doesn't want to use the keyboard.
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
   * Constructor for GameWindow class.
   * Create the panel.
   */
  public GameWindow() {
    setLayout(null);
    setPreferredSize(new Dimension(270 ,400));
    setMinimumSize(new Dimension(260,400));

    this.gamePanel = new JPanel();
    this.gamePanel.setBounds(10, 11, 240, 160);
    add(gamePanel);

    JButton up = new JButton("^");
    up.setBounds(55, 230, 40, 40);
    add(up);

    JButton down = new JButton("v");
    down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    down.setBounds(55, 310, 40, 40);
    add(down);

    JButton right = new JButton(">");
    right.setBounds(95, 270, 40, 40);
    add(right);

    JButton left = new JButton("<");
    left.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      }
    });
    left.setBounds(15, 270, 40, 40);
    add(left);

    JButton btnA = new JButton("A");
    btnA.setBounds(140, 232, 50, 60);
    add(btnA);

    JButton btnB = new JButton("B");
    btnB.setBounds(200, 232, 50, 60);
    add(btnB);

    JButton btnStart = new JButton("Start");
    btnStart.setBounds(141, 319, 89, 23);
    add(btnStart);

  }

}
