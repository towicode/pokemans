package view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class GameWindow extends JFrame {

  public JPanel gamePanel;

  /**
   * Create the panel.
   */
  public GameWindow() {
    setLayout(null);
    setPreferredSize(new Dimension(270 ,500));
    setMinimumSize(new Dimension(260,500));

    this.gamePanel = new JPanel();
    this.gamePanel.setBounds(10, 11, 240, 160);
    add(gamePanel);

    JButton up = new JButton("^");
    up.setBounds(55, 330, 40, 40);
    add(up);

    JButton down = new JButton("v");
    down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    down.setBounds(55, 410, 40, 40);
    add(down);

    JButton right = new JButton(">");
    right.setBounds(95, 370, 40, 40);
    add(right);

    JButton left = new JButton("<");
    left.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      }
    });
    left.setBounds(15, 370, 40, 40);
    add(left);

    JButton btnA = new JButton("A");
    btnA.setBounds(220, 332, 50, 60);
    add(btnA);

    JButton btnB = new JButton("B");
    btnB.setBounds(280, 332, 50, 60);
    add(btnB);

    JButton btnStart = new JButton("Start");
    btnStart.setBounds(241, 419, 89, 23);
    add(btnStart);

  }

}
