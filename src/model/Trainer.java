package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import controller.Engine;

public class Trainer {

	private final Engine engine;
	private final SpriteLoader loader;
	private final int tileX = 112;
	private final int tileY = 80;
	private int step_counter = 0;

	// player
	private BufferedImage mySprite;
	private boolean ridingBicycle = false;
	private Direction direction = Direction.SOUTH;
	private boolean appearanceUpdateFlag = false;
	private int animationFrame = -1;
	private long lastAnimationSequence = 0L;

	public Trainer(Engine engine, SpriteLoader loader) {
		this.engine = engine;
		this.loader = loader;
	}

	public void update(Keyboard keyboard, Map map, Graphics g) {

		if (appearanceUpdateFlag) {
			appearanceUpdateFlag = false;
			updateAppearance();
		}
		if (!handleMovementRequest(keyboard, map))
			return;

		if (appearanceUpdateFlag) {
			int step_ensure = 0;
			while (step_ensure <= 3)
				step_ensure = animate(map, step_ensure, g);
			
			switch (direction) {
			case NORTH:
				map.setTileY(map.getTileY() - 1);
				break;
			case SOUTH:
				map.setTileY(map.getTileY() + 1);
				break;
			case EAST:
				map.setTileX(map.getTileX() - 1);
				break;
			case WEST:
				map.setTileX(map.getTileX() + 1);
				break;
			}
			step_counter++;
			System.out.println("Location is "+ map.getTileX() + " " + map.getTileY() + "  Steps Taken: " + step_counter);
		}
	}

	public void draw(Graphics graphics) {
		if (mySprite == null) {
			updateAppearance(); // let's try to fix it first.. just incase..
		}
		if (mySprite != null) {

			graphics.drawImage(mySprite, tileX, tileY, null);
		}
	}

	public boolean handleMovementRequest(Keyboard keyboard,Map map) {

		boolean positionUpdateFlag = false;

		int keyCode = -1;
		if (keyboard.isKeyPressed(KeyEvent.VK_UP)
				|| keyboard.isKeyPressed(KeyEvent.VK_W)) {
			keyCode = KeyEvent.VK_UP;
			positionUpdateFlag = true;
		}
		if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)
				|| keyboard.isKeyPressed(KeyEvent.VK_S)) {
			keyCode = KeyEvent.VK_DOWN;
			positionUpdateFlag = true;
		}
		if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)
				|| keyboard.isKeyPressed(KeyEvent.VK_A)) {
			keyCode = KeyEvent.VK_LEFT;
			positionUpdateFlag = true;
		}
		if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)
				|| keyboard.isKeyPressed(KeyEvent.VK_D)) {
			keyCode = KeyEvent.VK_RIGHT;
			positionUpdateFlag = true;
		}
		if (positionUpdateFlag) {
			appearanceUpdateFlag = true;
			switch (keyCode) {
			case KeyEvent.VK_UP:
				direction = Direction.NORTH;
				Tile xN = map.getTiles()[map.getTileX()][map.getTileY()-1];
				for (int bad_text : Constants.NOT_WALKABLE_TEXTURES){
					if (xN.texture == bad_text)
						return false;
				}
				break;
			case KeyEvent.VK_DOWN:
				direction = Direction.SOUTH;
				Tile xS = map.getTiles()[map.getTileX()][map.getTileY()+1];
				for (int bad_text : Constants.NOT_WALKABLE_TEXTURES){
					if (xS.texture == bad_text)
						return false;
				}
				break;
			case KeyEvent.VK_LEFT:
				direction = Direction.EAST;
				Tile xE = map.getTiles()[map.getTileX()-1][map.getTileY()];
				for (int bad_text : Constants.NOT_WALKABLE_TEXTURES){
					if (xE.texture == bad_text)
						return false;
				}
				break;
			case KeyEvent.VK_RIGHT:
				direction = Direction.WEST;
				Tile xW = map.getTiles()[map.getTileX()+1][map.getTileY()];
				for (int bad_text : Constants.NOT_WALKABLE_TEXTURES){
					if (xW.texture == bad_text)
						return false;
				}
				break;
			}
			return true;
		}
		return false;
	}

	private int animate(Map map, int step_ensure, Graphics g) {
		if (lastAnimationSequence <= System.currentTimeMillis() - 150) {
			lastAnimationSequence = System.currentTimeMillis();
			animationFrame++;
			if (animationFrame > 2) {
				animationFrame = 0;
				appearanceUpdateFlag = true;
			}
			switch (direction) {
			case NORTH:
				map.adjustDown();
				break;
			case SOUTH:
				map.adjustUp();
				break;
			case EAST:
				map.adjustRight();
				break;
			case WEST:
				map.adjustLeft();
				break;
			}
			updateAppearance();
			step_ensure++;
			map.draw((Graphics2D) g);
			draw(g);
		}
		return step_ensure;
	}

	private void updateAppearance() {
		try {
			int animationSequence = (direction.getId() * 3) + animationFrame;
			mySprite = loader.getPlayer(animationSequence, ridingBicycle);
		} catch (Exception e) {
			System.err.println("Requested sprite is null!");
		}
	}

	public void toggleBicycle() {
		ridingBicycle = !ridingBicycle;
		appearanceUpdateFlag = true;
	}

}