package hangman.drawables;

import hangman.client.Drawable;

import java.awt.Color;
import java.awt.Graphics;

public class StateFive implements Drawable{

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(70, 20, 70, 30);
	}
}