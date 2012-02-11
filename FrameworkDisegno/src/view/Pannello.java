package view;

import grafica.componenti.contenitori.PannelloBase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;

import view.oggetti.Rettangolo;
import view.oggetti.Segmento;
import view.oggetti.punte.PuntaTriangolo;

public class Pannello extends PannelloBase {

	private Rettangolo ret;

	public Rettangolo getRet() {
		return ret;
	}

	public void setRet(final Rettangolo ret) {
		this.ret = ret;
	}

	private static final long serialVersionUID = 1L;

	public Pannello(final Container contenitore) {
		super(contenitore);
		ret = new Rettangolo();
		ret.setSize(100, 100);
		ret.setLocation(0, 0);
		ret.setBackground(Color.GREEN);
		
		MyMouseListener mouseListener = new MyMouseListener();
		this.addMouseListener(mouseListener.getMouseAdapter());
		this.addMouseMotionListener(mouseListener.getMouseMotionAdapter());
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		ret.draw(g);
	}
}
