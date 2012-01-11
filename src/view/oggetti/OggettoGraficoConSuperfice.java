package view.oggetti;

import java.awt.Dimension;
import java.awt.Point;

import view.oggetti.painter.IPainter;

public abstract class OggettoGraficoConSuperfice extends OggettoGrafico implements IOggettoGraficoConSuperficie, IOggettoGraficoComplesso {

	private int width;
	private int height;
	private int x;
	private int y;
	public Point distanzaMouseDaXY;

	public OggettoGraficoConSuperfice(final String nome, final IPainter painter) {
		super(nome, painter);
	}

	public OggettoGraficoConSuperfice() {
		super();
	}

	@Override
	public Dimension getSize() {
		return new Dimension(width, height);
	}

	@Override
	public void setSize(final int width, final int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setWidth(final int width) {
		this.width = width;
	}

	@Override
	public void setHeight(final int height) {
		this.height = height;
	}

	@Override
	public Point getLocation() {
		return new Point(x, y);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(final int x) {
		this.x = x;
	}

	@Override
	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public void setLocation(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Sposta l'oggetto grafico in relazione alla posizione x, y
	* 
	* @param x
	* @param y
	*/
	public void moveTo(final int x, final int y) {
		if (distanzaMouseDaXY != null) {
			int xx = (x + (int) distanzaMouseDaXY.getX());
			int yy = (y + (int) distanzaMouseDaXY.getY());
			this.setLocation(xx, yy);
		}
	} // moveTo

	/**
	 * Seleziona l'oggetto grafico e setta le coordinate del puntatore del mouse
	 * 
	 * @param puntatoreMouse
	 */
	public void settaDistanzaDaMouse(final Point puntatoreMouse) {
		if (puntatoreMouse != null) {
			final Point distanza = new Point((int) puntatoreMouse.getX() - getX(), (int) puntatoreMouse.getY() - getY());
			this.distanzaMouseDaXY = distanza;
		}
	}

}
