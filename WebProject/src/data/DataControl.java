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
import java.util.ArrayList;
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


	public DataControl(String putanja, Volonter v, Teritorija t, Komentar k, VanrednaSituacija vs) {
		super();
		this.putanja = putanja;
		volonteri.put(v.getKorIme(), v);
		teritorije.put(t.getNaziv(), t);
		komentari.put(k.getKorisnikKomentara(), k);
		vanredneSit.put(vs.getId(), vs);
		
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
		String id = "";
		
		for (Object kom : komJsonArray) {
			JSONObject jkom = (JSONObject) kom;
			tekst = (String) jkom.get("tekstKomentara");
			datum = (String) jkom.get("datumKomentarisanja");
			pisac = (String) jkom.get("korisnikKomentara");
			id = (String) jkom.get("id");

			
			Komentar newKomentar = new Komentar(tekst, convertToDate(datum), pisac, id);
			
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


public void readVanredneSitJson(String putanja) throws IOException, ParseException{
	
	JSONParser parser = new JSONParser();
	
	try{
		
		Object object  = parser.parse(new FileReader(/*putanja + */"DataBaseFolder//VanredneSituacije.json"));
		JSONObject jsonObj = (JSONObject) object;
		JSONArray vanredneSitJsonArray = (JSONArray) jsonObj.get("vanredneSituacije");
		

		String nazivMesta = "";
		String opstina = "";
		String opis = "";
		String datum = "";
		String lokacija = "";
		String nivoHitnosti = "";
		String slika = "";
		String stanje = "";
		String id = "";		
		
		for (Object vs : vanredneSitJsonArray) {
			JSONObject jvs = (JSONObject) vs;
			JSONObject jsonTerRead = (JSONObject) jvs.get("teritorija");
			
			nazivMesta = (String)jvs.get("nazivMesta");
			opstina = (String)jvs.get("opstina");
			opis = (String)jvs.get("opisDesavanja");
			datum = (String)jvs.get("datumVreme");
			lokacija= (String)jvs.get("tacnaLokacija");
			nivoHitnosti = (String)jvs.get("nivoHitnosti");
			slika = (String)jvs.get("slikaLokacije");
			stanje = (String)jvs.get("stanje");
			
			Teritorija ter = new Teritorija();
			ter.setNaziv((String) jsonTerRead.get("naziv"));
			ter.setPovrsina((double) jsonTerRead.get("povrsina"));
			ter.setBrStanovnika((long) jsonTerRead.get("brStanovnika"));
			
			NivoHitnosti nivo = NivoHitnosti.valueOf(nivoHitnosti);
			
			JSONObject jsonVolonterRead = (JSONObject) jvs.get("volonter");
			String korisnickoIme = (String) jsonVolonterRead.get("korIme");
			Volonter volonterVs = volonteri.get(korisnickoIme);
			
			JSONArray jsonKomentari = (JSONArray) jvs.get("komentari");
            ArrayList<Komentar> komVs = new ArrayList<Komentar>();
            
            if(jsonKomentari != null && jsonKomentari.size()>0 ) {
            	for(Object kom : jsonKomentari) {
            		JSONObject kom1 = (JSONObject) kom;
            		komVs.add(this.komentari.get(kom1.get("id")));
            	}
            }
            
            id = (String) jvs.get("id");
			
			VanrednaSituacija newVs = new VanrednaSituacija(nazivMesta, opstina, opis, 
			convertToDate(datum), lokacija, ter, nivo, slika, stanje, 
			volonterVs, komVs, id);
			
			
			vanredneSit.put(id, newVs);
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
	formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	date = formatter.parse(datum);
	return date;
}
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	
	
	@SuppressWarnings("unchecked")
	public void writeKomentariJson(String putanja){
		JSONArray ja = new JSONArray();
		JSONObject jobj = new JSONObject();
		
		for (Komentar k : komentari.values()) {
			JSONObject jobj2 = new JSONObject();
			jobj2.put("tekstKomentara", k.getTekstKomentara());
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			jobj2.put("datumKomentarisanja", format.format(k.getDatumKomentarisanja()));
			jobj2.put("korisnikKomentara", k.getKorisnikKomentara());
			jobj2.put("id", k.getId());
			
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
	
	
	@SuppressWarnings("unchecked")
	public void writeVanredneSitJson(String putanja){
		JSONArray ja = new JSONArray();
		JSONObject jobj = new JSONObject();
		
		for (VanrednaSituacija vs : vanredneSit.values()) {
			JSONObject jobj2 = new JSONObject();
			JSONObject objTeritorija = new JSONObject();	//pisanje objekta teritorija.
			JSONObject objVolonter = new JSONObject();		//pisanje ojekta volonter.
			JSONArray arrayKomentara = new JSONArray();		//pisanje liste komentara.
			
			jobj2.put("nazivMesta", vs.getNazivMesta());
			jobj2.put("opstina", vs.getOpstina());
			jobj2.put("opisDesavanja", vs.getOpisDesavanja());
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			jobj2.put("datumVreme", format.format(vs.getDatumVreme()));
			jobj2.put("tacnaLokacija", vs.getTacnaLokacija());
			
			objTeritorija.put("naziv", vs.getTeritorija().getNaziv());
			objTeritorija.put("povrsina", vs.getTeritorija().getPovrsina());
			objTeritorija.put("brStanovnika", vs.getTeritorija().getBrStanovnika());

			jobj2.put("teritorija", objTeritorija);
			
			jobj2.put("nivoHitnosti", vs.getNivoHitnosti().toString());
			jobj2.put("slikaLokacije", vs.getSlikaLokacije());
			jobj2.put("stanje", vs.getStanje());
			
			if(!(vs.getVolonter() == null)) {	//ako postoji zaduzen volonter upisujemo ga. 
				objVolonter.put("korIme", vs.getVolonter().getKorIme());
				objVolonter.put("lozinka", vs.getVolonter().getLozinka());
				objVolonter.put("ime", vs.getVolonter().getIme());
				objVolonter.put("prezime", vs.getVolonter().getPrezime());
				objVolonter.put("telefon", vs.getVolonter().getTelefon());
				objVolonter.put("email", vs.getVolonter().getEmail());
				objVolonter.put("teritorija", vs.getVolonter().getTeritorija());
				objVolonter.put("slika", vs.getVolonter().getSlika());
				//objVolonter.put("isAdmin", vs.getVolonter().getAdmin());
				objVolonter.put("stanje", vs.getVolonter().getStanje());
			}
			jobj2.put("volonter", objVolonter);
			
			if(!(vs.getKomentari() == null)){
				for (Komentar kom : vs.getKomentari()) {
					JSONObject objKomentari = new JSONObject();
					//objKomentari.put("id", k.getId());
					objKomentari.put("tekstKomentara", kom.getTekstKomentara());
					objKomentari.put("datumKomentarisanja", format.format(kom.getDatumKomentarisanja()));
					objKomentari.put("korisnikKomentara", kom.getKorisnikKomentara());
					objKomentari.put("id", kom.getId());
					arrayKomentara.add(objKomentari);
				}
			}
			
			jobj2.put("komentari", arrayKomentara);
			jobj2.put("id", vs.getId());
			
			ja.add(jobj2);
		}
		
		try{
			jobj.put("vanredneSituacije", ja);
			FileWriter writer = new FileWriter(/*putanja + */"DataBaseFolder//VanredneSituacije.json");
			writer.write(jobj.toString());
			writer.flush();
			writer.close();
		}
		catch(IOException ee){
			ee.printStackTrace();
		}
		
	}

}
