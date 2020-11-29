package currency.scommettitoreApp.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.Valute;
import currency.scommettitoreApp.filtriEstatistiche.Filtri;
import currency.scommettitoreApp.model.Ausiliare;
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
	
	public HashMap<String,ModelloValuta> GetStatistiche(String from, String to,String currencies){
		return HashMapModello.HashMapValori(Data.CiclaDate(from,to,currencies));	
	}
	
	public ArrayList<Ausiliare> GetCostanti(String from, String to, String filtro, String currencies) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		 return Filtri.filtri(filtro,HashMapModello.HashMapValori(Data.CiclaDate(from, to,currencies)));
	}
}
