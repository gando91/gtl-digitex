package hangman.drawables;

import hangman.client.Drawable;

import java.awt.Color;
import java.awt.Graphics;

public class StateOne implements Drawable{

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 150, 150);
	}
}
