package view.oggetti;

import java.awt.Point;

import view.oggetti.painter.PainterSegmento;

public class Segmento extends OggettoGrafico{

	Point origine;
	Point destinazione;
	
	public Segmento(Point origine, Point destinazione) {
		this.origine = origine;
		setPainter(new PainterSegmento(this));
	}
	
	@Override
	public Point getPuntoCentrale() {
		int x = (int) ((origine.getX() + destinazione.getX()) / 2);
		int y = (int) ((origine.getY() + destinazione.getY()) / 2);
		return new Point(x, y);
	}
	
	public Point getOrigine() {
		return origine;
	}
	public void setOrigine(Point origine) {
		this.origine = origine;
	}
	public Point getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(Point destinazione) {
		this.destinazione = destinazione;
	}

}
