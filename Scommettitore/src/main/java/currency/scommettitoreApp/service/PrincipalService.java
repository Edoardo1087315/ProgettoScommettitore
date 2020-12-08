package currency.scommettitoreApp.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import currency.scommettitoreApp.Plot.Grafico;
import currency.scommettitoreApp.currencylayer.Valute;
import currency.scommettitoreApp.exceptions.DataException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.filtriEstatistiche.Filtri;
import currency.scommettitoreApp.model.ValuteCostanti;
import currency.scommettitoreApp.model.HashMapModello;
import currency.scommettitoreApp.model.Metadata;
import currency.scommettitoreApp.model.ModelloValuta;
import currency.scommettitoreApp.model.ValuteCostanti;

@org.springframework.stereotype.Service
public class PrincipalService {

	public Vector<String> GetValute() throws UrlException {
		return Valute.GetStringsValute();

	}

	public HashMap<String, String> GetMetadata() {
		return Metadata.GetMetadata();
	}
	
	public HashMap<String,ModelloValuta> GetStatistiche(String from, String to,String currencies) throws UrlException, DataException{
		return HashMapModello.HashMapValori(DataService.CiclaDate(from,to,currencies));	
	}
	
	public ArrayList<ValuteCostanti> GetCostanti(String from, String to, String filtro, String currencies) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, UrlException, DataException, JsonMappingException, JsonProcessingException{
		 return Filtri.filtri(filtro,HashMapModello.HashMapValori(DataService.CiclaDate(from, to,currencies)));
	}
	
	public byte[] GetGrafico(String from, String to, String currencies) throws Exception {
		return Grafico.GraficoLineare(HashMapModello.HashMapValori(DataService.CiclaDate(from, to, currencies)), from, to);
	}
}
