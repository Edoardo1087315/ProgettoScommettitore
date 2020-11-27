package currency.scommettitoreApp.service;

import java.util.HashMap;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.Valute;
import currency.scommettitoreApp.model.HashMapModello;
import currency.scommettitoreApp.model.Metadata;
import currency.scommettitoreApp.model.ModelloValuta;

@org.springframework.stereotype.Service
public class PrincipalService {

	public Vector<String> GetValute() {
		return Valute.GetStringsValute();

	}

	public HashMap<String, String> GetMatadata() {
		return Metadata.GetMetadata();
	}
	
	public HashMap<String,ModelloValuta> GetStatistiche(String from, String to){
		return HashMapModello.HashMapValori(Data.CiclaDate(from,to));	
	}

}
