package view.oggetti;

public class Quadrato extends Rettangolo {

	@Override
	public int getArea() {
		return (int) Math.pow(getLatoAlto().getLunghezza(), 2);
	}

	@Override
	public int getPerimetro() {
		return getLatoAlto().getLunghezza() * 4;
	}
}
