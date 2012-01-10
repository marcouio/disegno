package view.oggetti;

import java.awt.Point;

import view.oggetti.painter.IPainter;
import view.oggetti.painter.PainterRettangolo;

public class Rettangolo extends OggettoGraficoComplesso implements IOggettoGraficoConSuperficie{
	
	private Point altoSinitra = new Point(getX(), getY());
	private Point altoDestra = new Point(getX() + getWidth(), getY());
	private Point bassoSinistra = new Point(getX(), getY() + getHeight());
	private Point bassoDestra = new Point(getX() + getWidth(), getY() + getHeight());
	
	private Lato latoAlto = new Lato(altoSinitra,altoDestra);
	private Lato latoBasso = new Lato(bassoSinistra, bassoDestra);
	private Lato latoSinistra = new Lato(altoSinitra, bassoSinistra);
	private Lato latoDestra = new Lato(altoDestra, bassoDestra);
	
	public Rettangolo(final String nome, final IPainter painter) {
		super(nome, painter);
		init();
	}
	
	private void init() {
		add(latoAlto);
		add(latoBasso);
		add(latoDestra);
		add(latoSinistra);
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
		int puntoCentraleX = getX() + (getWidth()/2);
		int puntoCentrateY = getY() + (getHeight()/2);
		return new Point(puntoCentraleX, puntoCentrateY);
	}
	
	@Override
	public void setSize(int width, int height) {
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
	public void setLocation(int x, int y) {
		super.setLocation(x, y);
		settaLati();
	}
}
