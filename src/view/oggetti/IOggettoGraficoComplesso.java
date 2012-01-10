package view.oggetti;

public interface IOggettoGraficoComplesso extends IOggettoGrafico{

	public void add(final IOggettoGrafico oggettoGrafico);
	public void remove(final IOggettoGrafico oggettoGrafico);
	public IOggettoGrafico getChild(final int index);
}
