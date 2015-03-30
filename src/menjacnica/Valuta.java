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
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
			this.datum = datum;
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		this.kupovniKurs = kupovniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		this.srednjiKurs = srednjiKurs;
	}
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
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
