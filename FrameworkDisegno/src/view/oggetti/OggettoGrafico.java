package view.oggetti;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import view.oggetti.painter.IPainter;

public abstract class OggettoGrafico implements IOggettoGrafico{

	private int x;
	private int y;
	private int width;
	private int height;
	protected IPainter painter;
	private String nome;
	
	public OggettoGrafico() {
	}
	
	public OggettoGrafico(final IPainter painter) {
		this.painter = painter;
	}
	
	public OggettoGrafico(final String nome, final IPainter painter) {
		this.nome = nome;
		this.painter = painter;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(final String nome){
		this.nome = nome;
	}
	
	@Override
	public Point getLocation() {
		return new Point(x, y);
	}
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Dimension getSize() {
		return new Dimension(width, height);
	}
	
	@Override
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	public IPainter getPainter() {
		return painter;
	}
	
	public void setPainter(IPainter painter) {
		this.painter = painter;
	}
	
	@Override
	public void draw(final Graphics g) {
		painter.paint(g);
	}
	
	@Override
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
	
}
