package view.oggetti.painter;

import java.awt.Graphics;

import view.oggetti.IOggettoGrafico;

public class PainterBase implements IPainter {

	IOggettoGrafico oggettoGrafico;
	
	public PainterBase(final IOggettoGrafico oggettoGrafico) {
		this.oggettoGrafico = oggettoGrafico;
	}

	@Override
	public void paint(Graphics g) {
		if (
			(oggettoGrafico == null) ||
			(oggettoGrafico.getWidth() <= 0) || 
			(oggettoGrafico.getHeight() <= 0)) {
			return;
		}
	}

}
