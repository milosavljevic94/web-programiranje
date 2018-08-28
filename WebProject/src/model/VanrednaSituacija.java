package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Nemanja
 * Aug 29, 2018
 */

public class VanrednaSituacija {
	
	private String nazivMesta;
	private String opstina;
	private String opisDesavanja;
	private Date datumVreme;
	private String tacnaLokacija;
	private Teritorija teritorija;
	private NivoHitnosti nivoHitnosti;
	private String slikaLokacije;
	private String stanje;
	private Volonter volonter; //koji je zaduzen za lokaciju.
	private ArrayList<Komentar> komentari; //lista komentara vandredne situacije.
	private String id;
	
	
	public VanrednaSituacija() {
		super();
	}


	public VanrednaSituacija(String nazivMesta, String opstina, String opisDesavanja, Date datumVreme,
			String tacnaLokacija, Teritorija teritorija, NivoHitnosti nivoHitnosti, String slikaLokacije, String stanje,
			Volonter volonter, ArrayList<Komentar> komentari, String id) {
		super();
		this.nazivMesta = nazivMesta;
		this.opstina = opstina;
		this.opisDesavanja = opisDesavanja;
		this.datumVreme = datumVreme;
		this.tacnaLokacija = tacnaLokacija;
		this.teritorija = teritorija;
		this.nivoHitnosti = nivoHitnosti;
		this.slikaLokacije = slikaLokacije;
		this.stanje = stanje;
		this.volonter = volonter;
		this.komentari = komentari;
		this.id = id;
	}


	public String getNazivMesta() {
		return nazivMesta;
	}


	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}


	public String getOpstina() {
		return opstina;
	}


	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}


	public String getOpisDesavanja() {
		return opisDesavanja;
	}


	public void setOpisDesavanja(String opisDesavanja) {
		this.opisDesavanja = opisDesavanja;
	}


	public Date getDatumVreme() {
		return datumVreme;
	}


	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}


	public String getTacnaLokacija() {
		return tacnaLokacija;
	}


	public void setTacnaLokacija(String tacnaLokacija) {
		this.tacnaLokacija = tacnaLokacija;
	}


	public Teritorija getTeritorija() {
		return teritorija;
	}


	public void setTeritorija(Teritorija teritorija) {
		this.teritorija = teritorija;
	}


	public NivoHitnosti getNivoHitnosti() {
		return nivoHitnosti;
	}


	public void setNivoHitnosti(NivoHitnosti nivoHitnosti) {
		this.nivoHitnosti = nivoHitnosti;
	}


	public String getSlikaLokacije() {
		return slikaLokacije;
	}


	public void setSlikaLokacije(String slikaLokacije) {
		this.slikaLokacije = slikaLokacije;
	}


	public String getStanje() {
		return stanje;
	}


	public void setStanje(String stanje) {
		this.stanje = stanje;
	}


	public Volonter getVolonter() {
		return volonter;
	}


	public void setVolonter(Volonter volonter) {
		this.volonter = volonter;
	}


	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}


	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "VanrednaSituacija [nazivMesta=" + nazivMesta + ", opstina=" + opstina + ", opisDesavanja="
				+ opisDesavanja + ", datumVreme=" + datumVreme + ", tacnaLokacija=" + tacnaLokacija + ", teritorija="
				+ teritorija + ", nivoHitnosti=" + nivoHitnosti + ", slikaLokacije=" + slikaLokacije + ", stanje="
				+ stanje + ", volonter=" + volonter + ", komentari=" + komentari + "]";
	}
	
	
	
	
	

}
