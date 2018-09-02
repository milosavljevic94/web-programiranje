package data;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import data.*;
import model.*;
/**
 * @author Nemanja
 * Sep 1, 2018
 */
public class probaMain {

	public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
		DataControl dc = new DataControl();
		NivoHitnosti nh = NivoHitnosti.plavo;
		Volonter vol = new Volonter("dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds");
		Teritorija ter = new Teritorija("sasasa", 23.44, 1200);
		Komentar kom = new Komentar("sdasdasfrfwecdqwe", dc.convertToDate("2018-8-1 11:22:3"), "steva", "123");
		
		ArrayList<Komentar> lk = new ArrayList<Komentar>();
		lk.add(kom);
		
		VanrednaSituacija vs = new VanrednaSituacija("celarevo", "prva", "vetar", 
	    dc.convertToDate("2013-1-1 12:32:3"), "centar", ter, nh, "putanja do slike", "normalno", vol, lk, "333");
		
		DataControl dc1 = new DataControl("DataBaseFolder//Volonteri.json", vol, ter, kom, vs);
		dc1.writeVolonterJson("DataBaseFolder//Volonteri.json");
		dc1.readVolonterJson("DataBaseFolder//Volonteri.json");
		
		dc1.writeTeritorijeJson("DataBaseFolder//Teritorije.json");
		dc1.readTeritorijeJson("DataBaseFolder//Teritorije.json");
		
		dc1.writeKomentariJson("dasd");
		dc1.readKomentareJson("dsad");
		
		dc1.writeVanredneSitJson("");
		dc1.readVanredneSitJson("");
		
	}

}
