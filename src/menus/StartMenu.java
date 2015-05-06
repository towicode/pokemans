package menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import model.Keyboard;
import abstracts.GameMenu;

public class StartMenu extends GameMenu {

	private static final int BOX_HEIGHT = 36;
	private static final int BOX_WIDTH = 240;
	private int currentlySelected = 0;
	private long lastAnimationSequence = 0;

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, StartMenu.BOX_WIDTH, BOX_HEIGHT);
		graphics.drawRect(0, BOX_HEIGHT, StartMenu.BOX_WIDTH, BOX_HEIGHT);

		graphics.drawString("Start Game", 15, 18);
		graphics.drawString("How to Play", 15, 54);

		graphics.setColor(Color.BLUE);

		switch (currentlySelected) {
		case 0:
			graphics.drawRect(0, 0, StartMenu.BOX_WIDTH, BOX_HEIGHT);
			break;
		case 1:
			graphics.drawRect(0, BOX_HEIGHT, StartMenu.BOX_WIDTH, BOX_HEIGHT);
			break;
		}

	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		int keyCode = -1;
		if (keyboard.isKeyPressed(KeyEvent.VK_UP)
				|| keyboard.isKeyPressed(KeyEvent.VK_W)) {
			keyCode = KeyEvent.VK_UP;
		}
		if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)
				|| keyboard.isKeyPressed(KeyEvent.VK_S)) {
			keyCode = KeyEvent.VK_DOWN;
		}
		if (keyboard.isKeyPressed(KeyEvent.VK_C)) {
			keyCode = KeyEvent.VK_C;
		}

		if (keyCode == KeyEvent.VK_UP) {
			if (currentlySelected == 0)
				return;
			currentlySelected--;
		}

		if (keyCode == KeyEvent.VK_DOWN) {
			if (currentlySelected == 1)
				return;
			currentlySelected++;
		}

		if (keyCode == KeyEvent.VK_C) {
			switch (currentlySelected) {
			case 0:
				// TODO run the engine
				break;
			case 1:
				// TODO open a how to play screen
				break;

			}

		}

	}
}
