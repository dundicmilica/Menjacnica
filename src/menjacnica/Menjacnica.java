package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnicainterfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	public LinkedList<Valuta> valuta = new LinkedList<Valuta>();

	public void dodajKurs(double prodajniKurs, double kupovniKurs,
			GregorianCalendar dan, String naziv, String skraceniNaziv) {
		
		Valuta v = new Valuta();
		
		v.setDatum(dan);
		v.setKupovniKurs(kupovniKurs);
		v.setProdajniKurs(prodajniKurs);
		v.setNaziv(naziv);
		v.setSkraceniNaziv(skraceniNaziv);
		v.setSrednjiKurs((prodajniKurs + kupovniKurs) / 2);
		
		valuta.add(v);
	}

	public void brisanjeKursa(GregorianCalendar dan, String naziv) {
		
		Valuta v = new Valuta();
		
		v.setDatum(dan);
		v.setNaziv(naziv);
		
		for (int i = 0; i < valuta.size(); i++) {
			if (valuta.get(i).equals(v))
				valuta.remove(i);
		}
	}

	public Valuta pronadjiKursNaDan(GregorianCalendar dan, String naziv) {
		
		Valuta v = new Valuta();
		Valuta pomValuta = null;
		
		v.setDatum(dan);
		v.setNaziv(naziv);
		
		for (int i = 0; i < valuta.size(); i++) {
			if (valuta.get(i).equals(v)) {
				pomValuta = v;
				break;
			}
		}
		return pomValuta;
	}
}
