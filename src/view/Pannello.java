package view;

import grafica.componenti.contenitori.PannelloBase;

import java.awt.Container;
import java.awt.Graphics;

import view.oggetti.Rettangolo;

public class Pannello extends PannelloBase{

	private static final long serialVersionUID = 1L;

	public Pannello(Container contenitore) {
		super(contenitore);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Rettangolo ret = new Rettangolo();
		ret.setSize(160, 140);
		ret.setLocation(30, 40);
		ret.draw(g);
	}
}
