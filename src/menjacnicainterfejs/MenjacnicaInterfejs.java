package menjacnicainterfejs;

import java.util.GregorianCalendar;

import menjacnica.Valuta;

public interface MenjacnicaInterfejs {

	public void dodajKurs(double prodajniKurs, double kupovniKurs, GregorianCalendar dan, String naziv, String skraceniNaziv);
	public void brisanjeKursa(GregorianCalendar dan, String naziv);
	public Valuta pronadjiKursNaDan(GregorianCalendar dan, String naziv);
}
