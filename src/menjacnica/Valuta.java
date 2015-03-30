package menjacnica;

import java.util.GregorianCalendar;

public class Valuta {

	private String naziv;
	private String skraceniNaziv;
	private GregorianCalendar datum;
	private double kupovniKurs;
	private double srednjiKurs; //racuna se na osnovu kupovnog i prodajnog; ne unosi se!
	private double prodajniKurs;
	

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty())
			throw new RuntimeException("Morate uneti naziv valute!");
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		if (skraceniNaziv.length() != 3)
			throw new RuntimeException("Sraceni naziv valute mora sadrzati 3 slova");
		this.skraceniNaziv = skraceniNaziv;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		GregorianCalendar danas = new GregorianCalendar();
		if (danas.get(GregorianCalendar.YEAR) == datum.get(GregorianCalendar.YEAR)
				&& danas.get(GregorianCalendar.DAY_OF_YEAR) == datum.get(GregorianCalendar.DAY_OF_YEAR))
			this.datum = datum;
		else throw new RuntimeException("Morate uneti kurs za danasnji dan!");
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		if (kupovniKurs <= 0)
			throw new RuntimeException("Kurs nije ispravno unesen!");
		this.kupovniKurs = kupovniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		if (srednjiKurs <= 0)
			throw new RuntimeException("Kurs nije ispravno unesen!");
		this.srednjiKurs = srednjiKurs;
	}
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
		if (prodajniKurs <= 0)
			throw new RuntimeException("Kurs nije ispravno unesen!");
		this.prodajniKurs = prodajniKurs;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Valuta))	//kada trazimo neku valutu na odredjen dan, poredi se samo
				return false;			//pravi naziv ili skraceni naziv; kurs nije bitan
		
		Valuta valuta = (Valuta) obj;
		GregorianCalendar valutaDan = valuta.getDatum();
		GregorianCalendar danas = new GregorianCalendar();
			if (danas.get(GregorianCalendar.YEAR) == valutaDan.get(GregorianCalendar.YEAR) 
					&& danas.get(GregorianCalendar.DAY_OF_YEAR) == valutaDan.get(GregorianCalendar.DAY_OF_YEAR)
					&& valuta.getNaziv().equals(naziv) && valuta.getSkraceniNaziv().equals(skraceniNaziv))
				return true;

			return false;
	}
	
	@Override
	public String toString() {
		return "Valuta (naziv: " + naziv + ", skraceniNaziv: " + skraceniNaziv
				+ ", datum: " + datum + ", kupovniKurs: " + kupovniKurs
				+ ", srednjiKurs: " + srednjiKurs + ", prodajniKurs: "
				+ prodajniKurs + ")";
	}
	
}
