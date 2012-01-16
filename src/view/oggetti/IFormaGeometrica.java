package view.oggetti;

import java.awt.Graphics;
import java.awt.Point;

public interface IFormaGeometrica {

	public Point getPuntoCentrale();

	public String getNome();

	public void setNome(final String nome);

	public void draw(final Graphics g);

	public void ridimensiona(Point mouse);
}