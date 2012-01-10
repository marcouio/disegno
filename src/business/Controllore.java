package business;

import grafica.componenti.contenitori.FrameBase;
import grafica.componenti.label.Label;

import java.awt.Color;

import view.Pannello;
import view.oggetti.Rettangolo;
import controller.ControlloreBase;

public class Controllore extends ControlloreBase{
	
	private static Controllore singleton;
	
	public static Controllore getSingleton() {
		if(singleton == null){
			singleton = new Controllore();
		}
		return singleton;
	}

	public static void main(String[] args) {
		Controllore.getSingleton().myMain(Controllore.getSingleton(), false, "app");
	}
	
	@Override
	public void mainOverridato(FrameBase frame) {
		Label l = new Label("Ciaooaciaocoac", frame.getContentPane());
		Pannello p = new Pannello(frame);
		p.setSize(200, 300);
		p.setBackground(Color.white);
		Rettangolo retta = new Rettangolo();
		retta.setSize(20, 20);
		System.out.println(retta.getPerimetro());
	}

	@Override
	public boolean setStartUtenteLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificaPresenzaDb() {
		// TODO Auto-generated method stub
		return false;
	}

}
