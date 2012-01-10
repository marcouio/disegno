package view.oggetti;

import java.awt.Dimension;

public interface IOggettoGraficoConSuperficie extends IOggettoGrafico{

	public int getWidth();
	public int getHeight();
	public void setWidth(final int width);
	public void setHeight(final int height);
	public void setSize(final int width,final int height);
	public Dimension getSize();
}
