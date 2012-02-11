package business;

import grafica.componenti.contenitori.FrameBase;
import grafica.componenti.label.Label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import view.Pannello;
import view.oggetti.Rettangolo;
import controller.ControlloreBase;
import disegno.UtilDisegno;

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
		p = new Pannello(frame);
		p.setSize(400, 600);
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
	}

	public static void mouseDragged(final MouseEvent e) {
		final int x = e.getX(), y = e.getY();
		Rettangolo ret = p.getRet();
		final Point puntatore = new Point(x, y);
		//		System.out.println("n lati vicini mouse: " + ret.isMouseSuiLati(puntatore).size());
		if (ret.getLatiSuMouse().size() > 0) {
			ret.ridimensiona(puntatore);
		} else if (ret.isMouseIsInRegion()) {
			ret.moveTo(x, y);
		}
		Image offscreen = null;
		Graphics bufferGraphics = null;
		Object[] returns = UtilDisegno.getImmagineBufferizzata(new Dimension(p.getWidth(), p.getHeight()), offscreen, bufferGraphics);
		bufferGraphics = (Graphics) returns[0];
		offscreen = (Image) returns[1];
		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.fillRect(0, 0, p.getWidth(), p.getHeight());
		bufferGraphics.setColor(Color.BLACK);
		ret.draw(bufferGraphics);
		p.getGraphics().drawImage(offscreen, 0, 0, null);

		//		System.out.println("*********************************");
		//		System.out.println("X Rettangolo: " + ret.getX());
		//		System.out.println("Y Rettangolo: " + ret.getY());
		//		System.out.println("Larghezza rettangolo: " + ret.getWidth());
		//		System.out.println("Altezza Rettangolo: " + ret.getHeight());
		//		System.out.println("Mouse X: " + puntatore.getX());
		//		System.out.println("Mouse Y: " + puntatore.getY());
		//		System.out.println("PuntoCentrale X,Y: " + ret.getPuntoCentrale().getX() + ", " + ret.getPuntoCentrale().getY());
		//		System.out.println("*********************************");
	}

	public static void mouseMoved(final MouseEvent e) {
	}

	public static void mousePressed(final MouseEvent e) {

		final int x = e.getX(), y = e.getY();
		final Point mouse = new Point(x, y);
		Rettangolo ret = p.getRet();
		ret.mouseIsInRegion(mouse);
		ret.settaLatiSuMouse(mouse);
		ret.settaDistanzaDaMouse(mouse);
	}

	public static void mouseReleased(final MouseEvent e) {
	}
}
