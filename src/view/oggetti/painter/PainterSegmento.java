package view.oggetti.painter;

import java.awt.Graphics;

import view.oggetti.IOggettoGrafico;
import view.oggetti.Segmento;


public class PainterSegmento extends PainterBase{

	public PainterSegmento(IOggettoGrafico oggettoGrafico) {
		super(oggettoGrafico);
	}

	@Override
	public void paint(Graphics g) {
		Segmento seg = (Segmento) oggettoGrafico;
		int x1 = (int) seg.getOrigine().getX();
		int y1 = (int) seg.getOrigine().getY();
		int x2 = (int) seg.getDestinazione().getX();
		int y2 = (int) seg.getDestinazione().getY();
		g.drawLine(x1, y1, x2, y2);
	}

}