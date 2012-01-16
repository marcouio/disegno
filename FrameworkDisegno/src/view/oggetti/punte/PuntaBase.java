package view.oggetti.punte;

import grafica.componenti.contenitori.PannelloBase;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.oggetti.FormaGeometricaComplessa;
import view.oggetti.Segmento;

public class PuntaBase extends FormaGeometricaComplessa{
	
	private Segmento linea;
	private Point estremoCentrale;
	private Segmento latoSinistro;
	private Segmento latoDestro;
	private int lunghezzaLati = 10;
	final double ARROW_ANGLE = Math.PI / 2;
	
	public PuntaBase(final Segmento segmento, final int lunghezzaLati) {
		this.linea = segmento;
		this.lunghezzaLati = lunghezzaLati;
		calcolaAngoloLati();
		
		add(latoSinistro);
		add(latoDestro);
	}
	
	private void calcolaAngoloLati() {
			Point origine = linea.getOrigine();
			Point destinazione = linea.getDestinazione();
		 	
	        estremoCentrale = origine;
	        
	        double dx = destinazione.getX() - origine.getX();
	        double dy = destinazione.getY() - origine.getY();
	        double angle = Math.atan2(dy, dx);
	        double x1 = destinazione.getX() - lunghezzaLati * Math.cos(angle + ARROW_ANGLE);
	        double y1 = destinazione.getY() - lunghezzaLati * Math.sin(angle + ARROW_ANGLE);
	        double x2 = destinazione.getX() - lunghezzaLati * Math.cos(angle - ARROW_ANGLE);
	        double y2 = destinazione.getY() - lunghezzaLati * Math.sin(angle - ARROW_ANGLE);
	        
	        
	}

	public PuntaBase(Segmento segmento) {
		this.linea = segmento;
	}

	@Override
	public Point getPuntoCentrale() {
		return estremoCentrale;
	}

	@Override
	public void ridimensiona(Point mouse) {
		// TODO Auto-generated method stub
		
	}
	
	 public static void main(String[] args) {
	    	SwingUtilities.invokeLater(new Runnable() {

	    		@Override
	    		public void run() {
	    			JFrame f = new JFrame();
	    			f.setVisible(true);
	    			f.getContentPane().add(new PannelloBase(f){
	    				@Override
	    				protected void paintComponent(Graphics g) {
	    					super.paintComponent(g);
	    					Point uno = new Point(120, 120);
	    					Point due = new Point(240, 50);
	    					Segmento l = new Segmento(uno, due);
	    					l.draw(g);
//	    					ArrowHead ah = new ArrowHead();
//	    					ArrowHead.NONE.draw((Graphics2D) g, uno, due);
//	    					ah.draw((Graphics2D) g, uno, due);
	    					PuntaBase punta = new PuntaBase(l, 20);
	    					punta.draw(g);
	    				}
	    			});
	    			f.setBounds(0, 0, 600, 500);
	    			f.addWindowListener(new WindowAdapter() {
	    				public void windowClosing(WindowEvent event) {
	    					System.exit(0);
	    				}
	    			});
	    		}
	    	});
	 }

}
