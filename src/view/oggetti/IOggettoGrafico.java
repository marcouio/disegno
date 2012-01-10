package view.oggetti;

import java.awt.Graphics;
import java.awt.Point;

public interface IOggettoGrafico {

	public Point getPuntoCentrale();
	public int getX();
	public int getY();
	public String getNome();
	public Point getLocation();
	public void setX(final int x);
	public void setY(final int y);
	public void setLocation(final int x, final int y);
	public void setNome(final String nome);
	public void draw(final Graphics g);
}
