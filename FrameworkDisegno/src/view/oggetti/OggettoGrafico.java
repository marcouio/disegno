package view.oggetti;

import java.awt.Graphics;

import view.oggetti.painter.IPainter;

public abstract class OggettoGrafico implements IOggettoGrafico {

	protected IPainter painter;
	private String nome;

	public OggettoGrafico() {
	}

	public OggettoGrafico(final IPainter painter) {
		this.painter = painter;
	}

	public OggettoGrafico(final String nome, final IPainter painter) {
		this.nome = nome;
		this.painter = painter;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setNome(final String nome) {
		this.nome = nome;
	}

	public IPainter getPainter() {
		return painter;
	}

	public void setPainter(final IPainter painter) {
		this.painter = painter;
	}

	@Override
	public void draw(final Graphics g) {
		painter.paint(g);
	}

}