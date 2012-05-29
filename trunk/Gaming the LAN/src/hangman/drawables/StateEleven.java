package hangman.drawables;

import java.awt.Color;
import java.awt.Graphics;

import hangman.client.Drawable;

public class StateEleven implements Drawable {

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(70, 75, 65, 85);
	}

}
