package hangman.drawables;

import hangman.client.Drawable;

import java.awt.Color;
import java.awt.Graphics;

public class StateTwo implements Drawable{

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(20, 100, 100, 100);
	}
}
