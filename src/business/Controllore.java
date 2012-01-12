package business;

import grafica.componenti.contenitori.FrameBase;
import grafica.componenti.label.Label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
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
		Label l = new Label("Ciaooaciaocoac", frame.getContentPane());
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
		if (ret.isMouseSuiLati(puntatore).size() > 0) {
			ret.ridimensiona(puntatore);
		} else if (UtilDisegno.isInRegion((int) (puntatore.getX()), (int) (puntatore.getY()), new Rectangle(new Dimension(ret.getWidth(), ret.getHeight())))) {
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
		//		ret.draw(p.getGraphics());

		System.out.println("*********************************");
		System.out.println("X Rettangolo: " + ret.getX());
		System.out.println("Y Rettangolo: " + ret.getY());
		System.out.println("Larghezza rettangolo: " + ret.getWidth());
		System.out.println("Altezza Rettangolo: " + ret.getHeight());
		System.out.println("Mouse X: " + puntatore.getX());
		System.out.println("Mouse Y: " + puntatore.getY());
		System.out.println("*********************************");
	}

	public static void mouseMoved(final MouseEvent e) {
		//		final int x = e.getX(), y = e.getY();
		//		Rettangolo ret = p.getRet();
		//		final Point puntatore = new Point(x, y);
		//		ret.seleziona(puntatore);
		//		ret.moveTo(x, y);
		//		ret.draw(p.getGraphics());
	}

	public static void mousePressed(final MouseEvent e) {
		p.getRet().distanzaMouseDaXY = null;
		final int x = e.getX(), y = e.getY();
		Rettangolo ret = p.getRet();
		final Point puntatore = new Point(x, y);
		ret.settaDistanzaDaMouse(puntatore);
	}

	public static void mouseReleased(final MouseEvent e) {
	}
}
