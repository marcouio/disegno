package view.oggetti.painter;

import java.awt.Graphics;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import view.oggetti.FormaGeometrica2D;
import view.oggetti.IFormaGeometrica;
import view.oggetti.Lato;

public class Painter2D extends PainterBase {

	public Painter2D(IFormaGeometrica oggettoGrafico) {
		super(oggettoGrafico);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		ArrayList<Lato> listaLati = ((FormaGeometrica2D)oggettoGrafico).getListaLati();
//		GeneralPath path = ((FormaGeometrica2D)oggettoGrafico).getPath();
//		if(listaLati!=null){
//			for (int i = 0; i < listaLati.size(); i++) {
//				Lato lato = listaLati.get(i);
//				if(i == 0){
//					path.moveTo(lato.getOrigine().getX(), lato.getOrigine().getY());
//				}else{
//					path.lineTo(lato.getOrigine().getX(), lato.getOrigine().getY());
//				}
//				path.lineTo(lato.getDestinazione().getX(), lato.getDestinazione().getY());
//				
//			}
//			path.closePath();
//		}
	}

}
