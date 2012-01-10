package view.oggetti.painter;

import java.awt.Graphics;

import view.oggetti.Rettangolo;

public class PainterRettangolo extends PainterBase {

	public PainterRettangolo(Rettangolo oggettoGrafico) {
		super(oggettoGrafico);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Rettangolo rettangolo = (Rettangolo) oggettoGrafico;
		rettangolo.draw(g);
	}

}
