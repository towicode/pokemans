package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Battle;

public class BattlePanel extends JPanel {
	public BattlePanel(Battle battoru){
	
	setLayout(new GridLayout(4,2));
	
	JButton ball = new JButton("Ball");
	JButton bait = new JButton("Bait");
	JButton rock = new JButton("Rock");
	JButton run = new JButton("Run");
	
	add(ball);
	add(bait);
	add(rock);
	add(run);
	
	ball.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			battoru.throwBall();
			
			//ToDo: animation
			
		}	
	});
	bait.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			battoru.throwBait();
			
			//ToDo: animation
			
		}		
	});
	rock.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			battoru.throwRock();
			
			//ToDo: animation
			
		}		
	});
		run.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			battoru.throwRock();
			
			//ToDo: animation, close window
			
		}
	});	
	}
}