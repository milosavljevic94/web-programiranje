/**
 * Klasa za rad sa podacima iz fajlova.
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.*;

/**
 * @author Nemanja
 * Aug 29, 2018
 */
public class DataControl {
	
	private String putanja;
	private HashMap<String, Volonter> volonteri = new HashMap<String, Volonter>();
	private HashMap<String, Komentar> komentari = new HashMap<String, Komentar>();
	private HashMap<String, Teritorija> teritorije = new HashMap<String, Teritorija>();
	private HashMap<String, VanrednaSituacija> vanredneSit = new HashMap<String, VanrednaSituacija>();
	
	
	public DataControl() {
		super();
	}


	public DataControl(String putanja, Volonter v, Teritorija t, Komentar k) {
		super();
		this.putanja = putanja;
		volonteri.put(v.getKorIme(), v);
		teritorije.put(t.getNaziv(), t);
		komentari.put(k.getKorisnikKomentara(), k);
		
	}
	
	public void readVolonterJson(String putanja) throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		
		try{
			
			Object object  = parser.parse(new FileReader(/*putanja + */"DataBaseFolder//Volonteri.json"));
			JSONObject jsonObj = (JSONObject) object;
			JSONArray volonteriJsonArray = (JSONArray) jsonObj.get("volonteri");
			System.out.println("size: "+volonteriJsonArray.size());
			System.out.println("Usao u read");
			

			String korIme = "";
			String lozinka = "";
			String ime = "";
			String prezime = "";
			String telefon = "";
			String email = "";
			String teritorija = "";
			String slika = "";
			String stanje = "";
			
			for (Object v : volonteriJsonArray) {
				System.out.println("Usao u for");
				JSONObject jv = (JSONObject) v;
				korIme = (String)jv.get("korIme");
				lozinka = (String)jv.get("lozinka");
				ime = (String)jv.get("ime");
				prezime = (String)jv.get("prezime");
				telefon= (String)jv.get("telefon");
				email = (String)jv.get("email");
				teritorija = (String)jv.get("teritorija");
				slika = (String)jv.get("slika");
				stanje = (String)jv.get("stanje");
				
				Volonter newVolonter = new Volonter(korIme, lozinka, ime, prezime, telefon, email, teritorija, slika, stanje);
				if(!volonteri.containsKey(korIme)){
					volonteri.put(korIme, newVolonter);
				}
			}
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
public void readTeritorijeJson(String putanja) throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		
		try{
			
			Object object  = parser.parse(new FileReader(/*putanja + */"DataBaseFolder//Teritorije.json"));
			JSONObject jsonObj = (JSONObject) object;
			JSONArray teritorijeJsonArray = (JSONArray) jsonObj.get("teritorije");
			
			String naziv = "";
			double povrsina = 0.0;
			long brStanovnika = 0;
			
			for (Object t : teritorijeJsonArray) {
				JSONObject jt = (JSONObject) t;
				naziv = (String)jt.get("naziv");
				povrsina = (double)jt.get("povrsina");
				brStanovnika = (long)jt.get("brStanovnika");

				
				Teritorija newTeritorija = new Teritorija(naziv, povrsina, brStanovnika);
				if(!teritorije.containsKey(naziv)){
					teritorije.put(naziv, newTeritorija);
				}
			}
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

public void readKomentareJson(String putanja) throws IOException, ParseException{
	
	JSONParser parser = new JSONParser();
	
	try{
		
		Object object  = parser.parse(new FileReader(/*putanja + */"DataBaseFolder//Komentari.json"));
		JSONObject jsonObj = (JSONObject) object;
		JSONArray komJsonArray = (JSONArray) jsonObj.get("komentari");
		
		String tekst = "";
		String datum = "";
		String pisac = "";
		
		for (Object kom : komJsonArray) {
			JSONObject jkom = (JSONObject) kom;
			tekst = (String)jkom.get("tekstKomentara");
			datum = (String)jkom.get("datumKomentarisanja");
			pisac = (String)jkom.get("korisnikKomentara");

			
			Komentar newKomentar = new Komentar(tekst, convertToDate(datum), pisac);
			
			komentari.put(pisac, newKomentar);
			
		}
	}
	catch(FileNotFoundException f){
		f.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}


public Date convertToDate(String datum) throws java.text.ParseException{
	DateFormat formatter;
	Date date;
	formatter = new SimpleDateFormat("yyyy-mm-dd");
	date = formatter.parse(datum);
	return date;
}
	
	public void writeVolonterJson(String putanja){
		System.out.println("usao u write.");
		JSONArray ja = new JSONArray();
		JSONObject jobj = new JSONObject();
		
		for (Volonter v : volonteri.values()) {
			JSONObject jobj2 = new JSONObject();
			jobj2.put("korIme", v.getKorIme());
			jobj2.put("lozinka", v.getLozinka());
			jobj2.put("ime", v.getIme());
			jobj2.put("prezime", v.getPrezime());
			jobj2.put("telefon", v.getTelefon());
			jobj2.put("email", v.getEmail());
			jobj2.put("teritorija", v.getTeritorija());
			jobj2.put("slika", v.getSlika());
			jobj2.put("stanje", v.getStanje());
			
			ja.add(jobj2);
		}
		
		try{
			jobj.put("volonteri", ja);
			FileWriter writer = new FileWriter(/*putanja + */"DataBaseFolder//Volonteri.json");
			writer.write(jobj.toString());
			writer.flush();
			writer.close();
		}
		catch(IOException ee){
			ee.printStackTrace();
		}
		
	}
	
	public void writeTeritorijeJson(String putanja){
		JSONArray ja = new JSONArray();
		JSONObject jobj = new JSONObject();
		
		for (Teritorija t : teritorije.values()) {
			JSONObject jobj2 = new JSONObject();
			jobj2.put("naziv", t.getNaziv());
			jobj2.put("povrsina", t.getPovrsina());
			jobj2.put("brStanovnika", t.getBrStanovnika());
			
			ja.add(jobj2);
		}
		
		try{
			jobj.put("teritorije", ja);
			FileWriter writer = new FileWriter(/*putanja + */"DataBaseFolder//Teritorije.json");
			writer.write(jobj.toString());
			writer.flush();
			writer.close();
		}
		catch(IOException ee){
			ee.printStackTrace();
		}
		
	}
	
	
	public void writeKomentariJson(String putanja){
		JSONArray ja = new JSONArray();
		JSONObject jobj = new JSONObject();
		
		for (Komentar k : komentari.values()) {
			JSONObject jobj2 = new JSONObject();
			jobj2.put("tekstKomentara", k.getTekstKomentara());
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			jobj2.put("datumKomentarisanja", format.format(k.getDatumKomentarisanja()));
			jobj2.put("korisnikKomentara", k.getKorisnikKomentara());
			
			ja.add(jobj2);
		}
		
		try{
			jobj.put("komentari", ja);
			FileWriter writer = new FileWriter(/*putanja + */"DataBaseFolder//Komentari.json");
			writer.write(jobj.toString());
			writer.flush();
			writer.close();
		}
		catch(IOException ee){
			ee.printStackTrace();
		}
		
	}

}
