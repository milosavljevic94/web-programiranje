package data;
import java.io.IOException;

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
		Volonter vol = new Volonter("dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds");
		Teritorija ter = new Teritorija("sasasa", 23.44, 1200);
		Komentar kom = new Komentar("sdasdasfrfwecdqwe", dc.convertToDate("2018-8-1"), "steva");
		DataControl dc1 = new DataControl("DataBaseFolder//Volonteri.json", vol, ter, kom);
		dc1.writeVolonterJson("DataBaseFolder//Volonteri.json");
		dc1.readVolonterJson("DataBaseFolder//Volonteri.json");
		
		dc1.writeTeritorijeJson("DataBaseFolder//Teritorije.json");
		dc1.readTeritorijeJson("DataBaseFolder//Teritorije.json");
		
		dc1.writeKomentariJson("dasd");
		dc1.readKomentareJson("dsad");
		
	}

}
