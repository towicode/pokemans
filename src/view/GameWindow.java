package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
    setPreferredSize(new Dimension(270 ,420));
    setMinimumSize(new Dimension(260,420));
    JMenuBar menuBar = new JMenuBar();
    JMenu optionsMenu = new JMenu("Options");
    JMenuItem quitItem = new JMenuItem("Quit");//item that will quit the program
	quitItem.addActionListener(new QuitActionListener());//action listener to quit the application
	JMenuItem infoItem = new JMenuItem("Info"); // item that shows info about the program
	infoItem.addActionListener(new InfoActionListener());
	optionsMenu.add(quitItem);
	optionsMenu.add(infoItem);
    menuBar.add(optionsMenu);
    
    this.setJMenuBar(menuBar);
       
    
    this.gamePanel = new JPanel();
    this.gamePanel.setBounds(10, 31, 240, 180);
    add(gamePanel);

    JButton up = new JButton("^");
    up.addActionListener(new UpActionListener() {
        public void actionPerformed(ActionEvent e) {
        }
      });
    up.setBounds(53, 228, 42, 42);
    add(up);

    JButton down = new JButton("v");
    down.addActionListener(new DownActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    down.setBounds(53, 312, 42, 42);
    add(down);

    JButton right = new JButton(">");
    right.addActionListener(new RightActionListener() {
        public void actionPerformed(ActionEvent e) {
        }
      });
    right.setBounds(95, 270, 42, 42);
    add(right);

    JButton left = new JButton("<");
    left.addActionListener(new LeftActionListener());
    left.setBounds(11, 270, 42, 42);
    add(left);

    JButton btnA = new JButton("A");
    btnA.setBounds(140, 232, 50, 60);
    add(btnA);

    JButton btnB = new JButton("B");
    btnB.setBounds(200, 232, 50, 60);
    add(btnB);

    JButton btnStart = new JButton("Start");
    btnStart.addActionListener(new StartActionListener()); // new
    btnStart.setBounds(141, 319, 89, 23);
    add(btnStart);

  }

  /**
   * Action Listener for the quit button 
   * 
   */
  private class QuitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);//exit the program
		}
		
  }
  /**
   * Action  Listener for the start button
   * 
   * 
   *
   */
  private class StartActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Create some kind of start menu: In the game or new JPanel?
			JOptionPane.showMessageDialog(null, new JLabel("This will be the start menu! The game stops working when this pops up! :D"
					+ " \n I think I need to be threaded!?"));
			
			
		}
		
  }
  /**
   *  Action Listener for Left button
   * 
   *
   */
  private class LeftActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Call for a Move left
		}
		
  }
  private class RightActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Call for a Move right
		}
  }
  private class UpActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Call for a Move up
		}
  }
  private class DownActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Call for a Move down
		}
  }
  private class InfoActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent arg0) {
		  JOptionPane.showMessageDialog(null, new JLabel("Programmed by Todd Wickizer, Andrew Rickus, and Sean Gemberling for Rick Snodgrass' CS335 section at the"
		  		+ "University of Arizona, spring semester, 2015. Project reviewer: Grogory Depaul"));
	  }
  }
}
