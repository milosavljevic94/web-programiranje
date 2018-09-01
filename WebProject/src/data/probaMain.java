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

	public static void main(String[] args) throws IOException, ParseException {
		Volonter vol = new Volonter("dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds", "dsds");
		Teritorija ter = new Teritorija("sasasa", 23.44, 1200);
		DataControl dc = new DataControl("DataBaseFolder//Volonteri.json", vol, ter);
		dc.writeVolonterJson("DataBaseFolder//Volonteri.json");
		dc.readVolonterJson("DataBaseFolder//Volonteri.json");
		
		dc.writeTeritorijeJson("DataBaseFolder//Teritorije.json");
		dc.readTeritorijeJson("DataBaseFolder//Teritorije.json");
		
	}

}
