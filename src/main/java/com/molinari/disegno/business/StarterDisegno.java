package com.molinari.disegno.business;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import com.molinari.disegno.view.Pannello;
import com.molinari.utility.controller.StarterBase;
import com.molinari.utility.graphic.component.container.FrameBase;
import com.molinari.utility.paint.UtilDisegno;
import com.molinari.utility.paint.objects.FormaGeometrica;
import com.molinari.utility.paint.objects.FormaGeometrica2D;
import com.molinari.utility.paint.objects.poligoni.Poligono;

public class StarterDisegno extends StarterBase {

	public static Pannello p;
	
	@Override
	public void start(FrameBase frameBase) {
		frameBase.setExtendedState(Frame.MAXIMIZED_BOTH);
		frameBase.setBounds(10, 20, 1024, 648);
		p = new Pannello(frameBase);
		p.setSize(400, 600);
		p.setBackground(Color.white);
		
		frameBase.setVisible(true);
	}
	
	public static void mouseClicked(final MouseEvent e) {
	}
	
	public static void mouseDragged(final MouseEvent e) {
		final int x = e.getX(), y = e.getY();
		
		if(p.getOggettoSelezionato() instanceof FormaGeometrica2D){
			FormaGeometrica2D ret = (FormaGeometrica2D) p.getOggettoSelezionato();
			final Point puntatore = new Point(x, y);
			boolean inRegion = ret.isInRegion(puntatore);
			System.out.println(inRegion);
			//		System.out.println("n lati vicini mouse: " + ret.isMouseSuiLati(puntatore).size());
			if (ret instanceof Poligono && ((Poligono)ret).getLatiVicinoMouse(puntatore).size() > 0) {
				ret.ridimensiona(puntatore);
			} else if (inRegion) {
				ret.moveTo(x, y);
			}
		}
		Image offscreen = null;
		Graphics bufferGraphics = null;
		Object[] returns = UtilDisegno.getImmagineBufferizzata(new Dimension(p.getWidth(), p.getHeight()), offscreen);
		bufferGraphics = (Graphics) returns[0];
		offscreen = (Image) returns[1];
		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.fillRect(0, 0, p.getWidth(), p.getHeight());
		bufferGraphics.setColor(Color.BLACK);
		if(p.getOggettoSelezionato()!=null){
			p.paint(bufferGraphics);
			p.getGraphics().drawImage(offscreen, 0, 0, null);
		}

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
		ArrayList<FormaGeometrica> oggetti = p.getOggetti();
		for (Iterator iterator = oggetti.iterator(); iterator.hasNext();) {
			FormaGeometrica formaGeometrica = (FormaGeometrica) iterator.next();
			boolean inRegion = formaGeometrica.isInRegion(mouse);
			System.out.println(inRegion);
			if(inRegion){
				p.setOggettoSelezionato(formaGeometrica);
				break;
			}
			
		}
		if(p.getOggettoSelezionato()!=null){
			FormaGeometrica forma = p.getOggettoSelezionato();
			if(forma instanceof Poligono){
				((Poligono) forma).setMouseSuiLati(mouse);
			}
			forma.settaDistanzaDaMouse(mouse);
		}
	}

	public static void mouseReleased(final MouseEvent e) {
	}
}
