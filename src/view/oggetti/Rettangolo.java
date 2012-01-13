package view.oggetti;

import java.awt.Dimension;
import java.awt.Point;

import view.oggetti.painter.IPainter;
import view.oggetti.painter.PainterRettangolo;

public class Rettangolo extends OggettoGraficoComplesso implements IOggettoGraficoConSuperficie {

	private Lato latoAlto = new Lato("Alto");
	private Lato latoBasso = new Lato("Basso");
	private Lato latoSinistra = new Lato("Sinistra");
	private Lato latoDestra = new Lato("Destra");
	public boolean nonModificaLarghezza = false;
	public boolean nonModificaAltezza = false;

	public Rettangolo(final String nome, final IPainter painter) {
		super(nome, painter);
		init();
	}

	private void init() {
		add(latoAlto);
		add(latoBasso);
		add(latoDestra);
		add(latoSinistra);
		getListaLati().add(latoAlto);
		getListaLati().add(latoBasso);
		getListaLati().add(latoDestra);
		getListaLati().add(latoSinistra);
	}

	public Rettangolo(final String nome) {
		setNome(nome);
		setPainter(new PainterRettangolo(this));
		init();
	}

	public Rettangolo() {
		setPainter(new PainterRettangolo(this));
		init();
	}

	public int getPerimetro() {
		return latoAlto.getLunghezza() + latoBasso.getLunghezza() + latoSinistra.getLunghezza() + latoDestra.getLunghezza();
	}

	public int getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public Point getPuntoCentrale() {
		int puntoCentraleX = getX() + (getWidth() / 2);
		int puntoCentrateY = getY() + (getHeight() / 2);
		return new Point(puntoCentraleX, puntoCentrateY);
	}

	@Override
	public void setSize(final int width, final int height) {
		super.setSize(width, height);
		settaLati();

	}

	private void settaLati() {
		this.latoAlto.setOrigine(new Point(getX(), getY()));
		this.latoAlto.setDestinazione(new Point(getX() + getWidth(), getY()));
		this.latoBasso.setOrigine(new Point(getX(), getY() + getHeight()));
		this.latoBasso.setDestinazione(new Point(getX() + getWidth(), getY() + getHeight()));
		this.latoDestra.setOrigine(new Point(getX() + getWidth(), getY()));
		this.latoDestra.setDestinazione(new Point(getX() + getWidth(), getY() + getHeight()));
		this.latoSinistra.setOrigine(new Point(getX(), getY()));
		this.latoSinistra.setDestinazione(new Point(getX(), getY() + getHeight()));
	}

	@Override
	public Point getLocation() {
		return super.getLocation();
	}

	@Override
	public void setLocation(final int x, final int y) {
		super.setLocation(x, y);
		settaLati();
	}

	public Lato getLatoAlto() {
		return latoAlto;
	}

	public Lato getLatoBasso() {
		return latoBasso;
	}

	public Lato getLatoSinistra() {
		return latoSinistra;
	}

	public Lato getLatoDestra() {
		return latoDestra;
	}

	@Override
	public void ridimensiona(final Point mouse) {

		int riferimentoLatiWidth = getWidth() / 2;
		int riferimentoLatiHeight = getHeight() / 2;
		Point puntoCentrale = getPuntoCentrale();

		//		boolean quadranteAltoDestra = mouse.getX() > puntoCentrale.getX() && mouse.getY() < puntoCentrale.getY();
		//		boolean quadranteBassoDestra = mouse.getX() > puntoCentrale.getX() && mouse.getY() > puntoCentrale.getY();
		boolean quadranteBassoSinistra = mouse.getX() < puntoCentrale.getX() && mouse.getY() > puntoCentrale.getY();
		boolean quadranteAltoSinistra = mouse.getX() < puntoCentrale.getX() && mouse.getY() < puntoCentrale.getY();

		if (quadranteBassoSinistra || quadranteAltoSinistra) {
			setX((int) (mouse.getX() - distanzaMouseDaXY.getX()));
			setY((int) (mouse.getY() - distanzaMouseDaXY.getY()));
		}
		//		setLocation(getX(), getY());
		setWidth((int) getNuoveDimensioni(mouse, riferimentoLatiHeight, puntoCentrale, riferimentoLatiWidth).getWidth());
		setHeight((int) getNuoveDimensioni(mouse, riferimentoLatiHeight, puntoCentrale, riferimentoLatiWidth).getHeight());
		setSize(getWidth(), getHeight());

	}

	public Dimension getNuoveDimensioni(final Point mouse, final int riferimentoLatiHeight, final Point puntoCentrale, final int riferimentoLatiWidth) {
		int newWidth = (int) (getX() + getWidth() - (getX() + getWidth() - mouse.getX()));
		int newHeight = (int) (getY() + getHeight() - (getY() + getHeight() - mouse.getY()));

		//		if (riferimentoLatiHeight > Math.abs(puntoCentrale.getY() - mouse.getY())) {
		if (nonModificaAltezza) {
			newHeight = getHeight();
		}
		//		if (riferimentoLatiWidth > Math.abs(puntoCentrale.getX() - mouse.getX())) {
		if (nonModificaLarghezza) {
			newWidth = getWidth();
		}
		return new Dimension(newWidth, newHeight);
	}

	//	public int ridimensionaAltezza(final Point mouse, final int riferimentoLatiHeight, final Point puntoCentrale) {
	//		if (Math.abs(puntoCentrale.getY() - mouse.getY()) > riferimentoLatiHeight) {
	//			return (int) (getY() + getHeight() - (getY() + getHeight() - mouse.getY()));
	//		}
	//		return getHeight();
	//	}
	//
	//	public int ridimensionaLarghezza(final Point mouse, final int riferimentoLatiWidth, final Point puntoCentrale) {
	//		if (Math.abs(puntoCentrale.getX() - mouse.getX()) > riferimentoLatiWidth) {
	//			return (int) (getX() + getWidth() - (getX() + getWidth() - mouse.getX()));
	//		}
	//		return getWidth();
	//	}
}
