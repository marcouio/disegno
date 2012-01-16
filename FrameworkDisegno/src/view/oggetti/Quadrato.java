package view.oggetti;

import view.oggetti.painter.IPainter;

public class Quadrato extends Rettangolo {

	public Quadrato(final String nome, final IPainter painter) {
		super(nome, painter);
	}

	public Quadrato(final String nome) {
		super(nome);
	}

	public Quadrato() {
		super();
	}

	public int getLato() {
		return getWidth();
	}

	public static void main(final String[] args) {
		Rettangolo rettangolo = new Rettangolo("ret");
		Quadrato quadrato = new Quadrato();
		quadrato.setSize(50, 50);
		rettangolo.setSize(100, 50);
		rettangolo = quadrato;
		rettangolo.setSize(50, 20);
		System.out.println(rettangolo.getArea());
	}
}
