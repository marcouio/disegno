package view.oggetti;

import java.awt.Dimension;

import view.oggetti.painter.IPainter;

public abstract class OggettoGraficoConSuperfice extends OggettoGrafico implements IOggettoGraficoConSuperficie, IOggettoGraficoComplesso{

	private int width;
	private int height;
	
	
	public OggettoGraficoConSuperfice(String nome, IPainter painter) {
		super(nome, painter);
	}

	public OggettoGraficoConSuperfice() {
		super();
	}

	@Override
	public Dimension getSize() {
		return new Dimension(width, height);
	}
	
	@Override
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
}
