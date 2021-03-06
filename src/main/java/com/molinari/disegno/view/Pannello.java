package com.molinari.disegno.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import com.molinari.utility.graphic.component.container.PannelloBase;
import com.molinari.utility.paint.objects.FormaGeometrica;
import com.molinari.utility.paint.objects.Segmento;
import com.molinari.utility.paint.objects.poligoni.Rettangolo;
import com.molinari.utility.paint.objects.punte.PuntaTriangolo;

public class Pannello extends PannelloBase {

	ArrayList<FormaGeometrica> oggetti = new ArrayList<FormaGeometrica>();
	FormaGeometrica oggettoSelezionato;

	private static final long serialVersionUID = 1L;

	public Pannello(final Container contenitore) {
		super(contenitore);
		Rettangolo ret = new Rettangolo();
		ret.setSize(100, 100);
		ret.setLocation(0, 0);
		ret.setBackground(Color.GREEN);
		oggetti.add(ret);
		Point uno = new Point(120, 120);
		Point due = new Point(240, 120);
		Segmento l = new Segmento(uno, due);
		PuntaTriangolo punta = new PuntaTriangolo(l, 20);
		punta.setBackground(Color.RED);
		oggetti.add(l);
		oggetti.add(punta);
		MyMouseListener mouseListener = new MyMouseListener();
		this.addMouseListener(mouseListener.getMouseAdapter());
		this.addMouseMotionListener(mouseListener.getMouseMotionAdapter());
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		for (int i = 0; i < oggetti.size(); i++) {
			FormaGeometrica oggetto = oggetti.get(i);
			oggetto.draw(g);
		}
	}

	public ArrayList<FormaGeometrica> getOggetti() {
		return oggetti;
	}

	public FormaGeometrica getOggettoSelezionato() {
		return oggettoSelezionato;
	}

	public void setOggettoSelezionato(FormaGeometrica oggettoSelezionato) {
		this.oggettoSelezionato = oggettoSelezionato;
	}
}
