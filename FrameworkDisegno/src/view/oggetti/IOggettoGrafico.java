package view.oggetti;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public interface IOggettoGrafico {

	public int getWidth();
	public int getHeight();
	public Point getPuntoCentrale();
	public int getX();
	public int getY();
	public String getNome();
	public Dimension getSize();
	public Point getLocation();
	public void setX(final int x);
	public void setY(final int y);
	public void setLocation(final int x, final int y);
	public void setSize(final int width,final int height);
	public void setWidth(final int width);
	public void setHeight(final int height);
	public void setNome(final String nome);
	public void draw(final Graphics g);
}
