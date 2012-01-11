package view;

import grafica.componenti.contenitori.PannelloBase;

import java.awt.Container;
import java.awt.Graphics;

import view.oggetti.Rettangolo;

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
		ret.setSize(160, 140);
		ret.setLocation(30, 40);
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
