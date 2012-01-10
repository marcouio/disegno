package view.oggetti;

import java.awt.Point;

public class Lato extends Segmento {

	public Lato(Point origine, Point destinazione) {
		super(origine, destinazione);
	}
	
	public Lato() {
		super(new Point(0, 0), new Point(0, 0));
	}

}
