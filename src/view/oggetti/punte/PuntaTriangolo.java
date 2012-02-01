package view.oggetti.punte;

import view.oggetti.Segmento;
import view.oggetti.painter.PainterPuntaTriangolo;

public class PuntaTriangolo extends PuntaBase {

	private Segmento latoBasso;

	public PuntaTriangolo(final Segmento segmento, final int lunghezzaLati) {
		super(segmento, lunghezzaLati);
		setPainter(new PainterPuntaTriangolo(this));
		aggiungiParteSpecificaPunta();
	}

	public PuntaTriangolo(final Segmento segmento) {
		super(segmento);
		aggiungiParteSpecificaPunta();
	}

	private void aggiungiParteSpecificaPunta() {
		latoBasso = new Segmento(getLatoSinistro().getDestinazione(), getLatoDestro().getDestinazione());
		add(latoBasso);
	}

}
