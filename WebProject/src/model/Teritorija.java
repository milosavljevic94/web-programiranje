package model;

/**
 * @author Nemanja
 * Aug 29, 2018
 */
public class Teritorija {
	
	private String naziv;
	private double povrsina;
	private int brStanovnika;
	
	
	public Teritorija() {
		super();
	}


	public Teritorija(String naziv, double povrsina, int brStanovnika) {
		super();
		this.naziv = naziv;
		this.povrsina = povrsina;
		this.brStanovnika = brStanovnika;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public double getPovrsina() {
		return povrsina;
	}


	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}


	public int getBrStanovnika() {
		return brStanovnika;
	}


	public void setBrStanovnika(int brStanovnika) {
		this.brStanovnika = brStanovnika;
	}


	@Override
	public String toString() {
		return "Teritorija [naziv=" + naziv + ", povrsina=" + povrsina + ", brStanovnika=" + brStanovnika + "]";
	}
	
	
		

}
