package view.oggetti;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import view.oggetti.painter.IPainter;

public abstract class OggettoGraficoComplesso extends OggettoGraficoConSuperfice implements IOggettoGraficoComplesso {

	ArrayList<IOggettoGrafico> listaOggetti = new ArrayList<IOggettoGrafico>();
	
	public OggettoGraficoComplesso(String nome, IPainter painter) {
		super(nome, painter);
	}
	
	public OggettoGraficoComplesso() {
		super();
	}	
	
	public OggettoGraficoComplesso(final IPainter painter) {
		this.painter = painter;
	}

	@Override
	public void draw(final Graphics g) {
		for (Iterator<IOggettoGrafico> iterator = listaOggetti.iterator(); iterator.hasNext();) {
			IOggettoGrafico oggettoGrafico = (IOggettoGrafico) iterator.next();
			oggettoGrafico.draw(g);
		}
	}

	@Override
	public void add(final IOggettoGrafico oggettoGrafico) {
		listaOggetti.add(oggettoGrafico);
	}

	@Override
	public void remove(final IOggettoGrafico oggettoGrafico) {
		listaOggetti.remove(oggettoGrafico);
	}

	@Override
	public IOggettoGrafico getChild(final int index) {
		return listaOggetti.get(index);
	}

}
