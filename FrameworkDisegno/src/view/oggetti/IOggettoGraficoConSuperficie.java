package view.oggetti;

import java.awt.Dimension;
import java.awt.Point;

public interface IOggettoGraficoConSuperficie extends IOggettoGrafico {

	public int getWidth();

	public int getHeight();

	public void setWidth(final int width);

	public void setHeight(final int height);

	public void setSize(final int width, final int height);

	public Dimension getSize();

	public int getX();

	public int getY();

	public void setX(final int x);

	public void setY(final int y);

	public void setLocation(final int x, final int y);

	public Point getLocation();

}
