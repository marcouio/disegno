package view.oggetti.painter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import view.oggetti.Rettangolo;

public class PainterRettangolo extends PainterBase {

	public PainterRettangolo(Rettangolo oggettoGrafico) {
		super(oggettoGrafico);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Rettangolo rettangolo = (Rettangolo) oggettoGrafico;
		Dimension d = new Dimension(rettangolo.getWidth(), rettangolo.getHeight());
		Shape shape = new Rectangle(rettangolo.getLatoAlto().getOrigine(), d);
		GeneralPath path = new GeneralPath(shape);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(rettangolo.getBackground());
		g2.fill(path);

		g2.setColor(Color.BLACK);
		g2.draw(path);
	}

}
