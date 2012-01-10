package view.oggetti;

import java.awt.Point;

import view.oggetti.painter.PainterSegmento;

public class Segmento extends OggettoGrafico{

	Point origine;
	Point destinazione;
	
	public Segmento(Point origine, Point destinazione) {
		this.origine = origine;
		this.destinazione = destinazione;
		setPainter(new PainterSegmento(this));
	}
	
	public Point getPuntoCentrale() {
		int x = (int) ((origine.getX() + destinazione.getX()) / 2);
		int y = (int) ((origine.getY() + destinazione.getY()) / 2);
		return new Point(x, y);
	}
	
	public int getLunghezza(){
		double base = Math.abs( origine.getX() - destinazione.getX() );
		double altezza = Math.abs( origine.getY() - destinazione.getY() );
		return (int) Math.sqrt(Math.pow(base, 2) + Math.pow(altezza, 2));
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
	
	public static void main(String[] args) {
		Segmento seg = new Segmento(new Point(20, 20), new Point(40, 40));
		System.out.println(seg.getLunghezza());
	}

}
