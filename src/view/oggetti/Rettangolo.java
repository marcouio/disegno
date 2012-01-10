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
		return latoAlto.getWidth() + latoBasso.getWidth() + latoSinistra.getWidth() + latoDestra.getWidth();
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
	public void setWidth(int width) {
		super.setWidth(width);
		this.latoAlto.setWidth(width);
		this.latoBasso.setWidth(width);
	}
	
	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		this.latoDestra.setWidth(height);
		this.latoSinistra.setWidth(height);
	}
	
	@Override
	public Point getLocation() {
		return super.getLocation();
	}
	
	@Override
	public void setLocation(int x, int y) {
		super.setLocation(x, y);
		this.latoAlto.setOrigine(new Point(x, y));
		this.latoAlto.setDestinazione(new Point(x + getWidth(), y));
		this.latoBasso.setOrigine(new Point(x, y + getHeight()));
		this.latoBasso.setDestinazione(new Point(x + getWidth(), y + getHeight()));
		this.latoDestra.setOrigine(new Point(x + getWidth(), y));
		this.latoDestra.setDestinazione(new Point(x + getWidth(), y + getHeight()));
		this.latoSinistra.setOrigine(new Point(x, y));
		this.latoSinistra.setDestinazione(new Point(x, y + getHeight()));
	}
}
