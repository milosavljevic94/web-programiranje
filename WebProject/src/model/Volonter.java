package model;

/**
 * @author Nemanja
 * Aug 29, 2018
 */

public class Volonter {
	
	private String korIme;
	private String lozinka;
	private String ime;
	private String prezime;
	private String telefon;
	private String email;
	private String teritorija;
	private String slika;
	private String stanje;
	
	public Volonter() {
		super();
	}

	public Volonter(String korIme, String lozinka, String ime, String prezime, String telefon, String email,
			String teritorija, String slika, String stanje) {
		super();
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.teritorija = teritorija;
		this.slika = slika;
		this.stanje = stanje;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeritorija() {
		return teritorija;
	}

	public void setTeritorija(String teritorija) {
		this.teritorija = teritorija;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getStanje() {
		return stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Volonter [korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", telefon=" + telefon + ", email=" + email + ", teritorija=" + teritorija + ", slika=" + slika
				+ ", stanje=" + stanje + "]";
	}
	
	
	
	
	
	

}
