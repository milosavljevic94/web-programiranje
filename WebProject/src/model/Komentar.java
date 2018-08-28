package model;

import java.util.Date;

/**
 * @author Nemanja
 * Aug 29, 2018
 */
public class Komentar {
	
	private String tekstKomentara;
	private Date datumKomentarisanja;
	private String korisnikKomentara;
	
	public Komentar() {
		super();
	}

	public Komentar(String tekstKomentara, Date datumKomentarisanja, String korisnikKomentara) {
		super();
		this.tekstKomentara = tekstKomentara;
		this.datumKomentarisanja = datumKomentarisanja;
		this.korisnikKomentara = korisnikKomentara;
	}
	

	public String getTekstKomentara() {
		return tekstKomentara;
	}

	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}

	public Date getDatumKomentarisanja() {
		return datumKomentarisanja;
	}

	public void setDatumKomentarisanja(Date datumKomentarisanja) {
		this.datumKomentarisanja = datumKomentarisanja;
	}

	public String getKorisnikKomentara() {
		return korisnikKomentara;
	}

	public void setKorisnikKomentara(String korisnikKomentara) {
		this.korisnikKomentara = korisnikKomentara;
	}

	@Override
	public String toString() {
		return "Komentar [tekstKomentara=" + tekstKomentara + ", datumKomentarisanja=" + datumKomentarisanja
				+ ", korisnikKomentara=" + korisnikKomentara + "]";
	}
	
	
	
	
	

}
