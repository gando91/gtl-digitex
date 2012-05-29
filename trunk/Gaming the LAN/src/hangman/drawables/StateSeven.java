package hangman.drawables;

import hangman.client.Drawable;

import java.awt.Color;
import java.awt.Graphics;

public class StateSeven implements Drawable{

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(70, 75, 60, 85);
	}
}
