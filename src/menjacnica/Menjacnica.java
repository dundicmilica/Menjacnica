package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnicainterfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	public LinkedList<Valuta> valuta = new LinkedList<Valuta>();

	public void dodajKurs(double prodajniKurs, double kupovniKurs,
			GregorianCalendar dan, String naziv, String skraceniNaziv) {
		// TODO Auto-generated method stub
		
	}

	public void brisanjeKursa(GregorianCalendar dan, String naziv) {
		// TODO Auto-generated method stub
		
	}

	public Valuta pronadjiKursNaDan(GregorianCalendar dan, String naziv) {
		// TODO Auto-generated method stub
		return null;
	}
}
