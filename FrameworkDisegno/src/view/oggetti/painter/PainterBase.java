package view.oggetti.painter;

import java.awt.Graphics;

import view.oggetti.IFormaGeometrica;

public class PainterBase implements IPainter {

	IFormaGeometrica oggettoGrafico;
	
	public PainterBase(final IFormaGeometrica oggettoGrafico) {
		this.oggettoGrafico = oggettoGrafico;
	}

	@Override
	public void paint(Graphics g) {
		if (oggettoGrafico == null){
			return;
		}
	}

}
