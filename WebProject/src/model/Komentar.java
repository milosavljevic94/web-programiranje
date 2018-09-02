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
	private String id;
	
	public Komentar() {
		super();
	}

	public Komentar(String tekstKomentara, Date datumKomentarisanja, String korisnikKomentara, String id) {
		super();
		this.tekstKomentara = tekstKomentara;
		this.datumKomentarisanja = datumKomentarisanja;
		this.korisnikKomentara = korisnikKomentara;
		this.id = id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Komentar [tekstKomentara=" + tekstKomentara + ", datumKomentarisanja=" + datumKomentarisanja
				+ ", korisnikKomentara=" + korisnikKomentara + "]";
	}
	
	
	
	
	

}
