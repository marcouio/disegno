package view.oggetti.painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import view.oggetti.IFormaGeometrica;
import view.oggetti.punte.PuntaTriangolo;

public class PainterPuntaTriangolo extends PainterPuntaBase {

	public PainterPuntaTriangolo(final IFormaGeometrica oggettoGrafico) {
		super(oggettoGrafico);
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		PuntaTriangolo puntaTriangolo = (PuntaTriangolo) getOggettoGrafico();
		GeneralPath path = new GeneralPath();
		path.lineTo(puntaTriangolo.getLatoDestro().getDestinazione().getX(), puntaTriangolo.getLatoDestro().getDestinazione().getY());
		path.lineTo(puntaTriangolo.getLatoSinistro().getDestinazione().getX(), puntaTriangolo.getLatoSinistro().getDestinazione().getY());
		path.lineTo(puntaTriangolo.getEstremoCentrale().getX(), puntaTriangolo.getEstremoCentrale().getY());
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fill(path);
	}
}
