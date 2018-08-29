/**
 * Klasa za rad sa podacima iz fajlova.
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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


	public DataControl(String putanja) {
		super();
		this.putanja = putanja;
	}
	
	private void readVolonterJson(String putanja) throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		
		try{
			
			Object object  = parser.parse(new FileReader(putanja + "DataBaseFolder//Volonteri.json"));
			JSONObject jsonObj = (JSONObject) object;
			JSONArray volonteriJsonArray = (JSONArray) jsonObj.get(volonteri);
			
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
				JSONObject jv = (JSONObject) v;
				korIme = (String)jv.get("korIme");
			}
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void writeVolonterJson(String putanja){
		
		
	}
	

}
