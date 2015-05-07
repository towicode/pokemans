package exceptions;

import java.awt.Graphics2D;

import model.Trainer;
import controller.Engine;

public class NoPokemansCaughtException extends Exception {
	public NoPokemansCaughtException(Graphics2D graphics) {
		Trainer trainer = Engine.getTrainer();
		if (trainer.getPokeman() == null || trainer.getPokeman().size() == 0) {
		      graphics.drawString("You don't have any...yet", 15, 15);
		  	  System.out.println("You haven't caught any Pokemans yet!");
		    }
	
	}
}
