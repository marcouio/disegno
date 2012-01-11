package business;

import grafica.componenti.contenitori.FrameBase;
import grafica.componenti.label.Label;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import view.Pannello;
import view.oggetti.Rettangolo;
import controller.ControlloreBase;

public class Controllore extends ControlloreBase {

	private static Controllore singleton;

	public static Controllore getSingleton() {
		if (singleton == null) {
			singleton = new Controllore();
		}
		return singleton;
	}

	public static void main(final String[] args) {
		Controllore.getSingleton().myMain(Controllore.getSingleton(), false, "app");
	}

	public static Pannello p;

	@Override
	public void mainOverridato(final FrameBase frame) {
		Label l = new Label("Ciaooaciaocoac", frame.getContentPane());
		p = new Pannello(frame);
		p.setSize(200, 300);
		p.setBackground(Color.white);
	}

	@Override
	public boolean setStartUtenteLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificaPresenzaDb() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void mouseClicked(final MouseEvent e) {
		//		final int x = e.getX(), y = e.getY();
		//		Rettangolo ret = p.getRet();
		//		final Point puntatore = new Point(x, y);
		//		ret.settaDistanzaDaMouse(puntatore);
		//		ret.moveTo(x, y);
		//		ret.draw(p.getGraphics());
	}

	public static void mouseDragged(final MouseEvent e) {
		final int x = e.getX(), y = e.getY();
		Rettangolo ret = p.getRet();
		final Point puntatore = new Point(x, y);
		ret.settaDistanzaDaMouse(puntatore);
		ret.moveTo(x, y);
		ret.draw(p.getGraphics());
	}

	public static void mouseMoved(final MouseEvent e) {
		//		final int x = e.getX(), y = e.getY();
		//		Rettangolo ret = p.getRet();
		//		final Point puntatore = new Point(x, y);
		//		ret.seleziona(puntatore);
		//		ret.moveTo(x, y);
		//		ret.draw(p.getGraphics());
	}
}
