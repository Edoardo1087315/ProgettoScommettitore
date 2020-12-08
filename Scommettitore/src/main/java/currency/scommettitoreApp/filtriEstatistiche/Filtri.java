package currency.scommettitoreApp.filtriEstatistiche;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.reflect.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.ValuteCostanti;
import currency.scommettitoreApp.model.ModelloValuta;

public class Filtri {

	public static ArrayList<ValuteCostanti> filtri(String filtro,HashMap<String,ModelloValuta> hs) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JsonMappingException, JsonProcessingException{
		
		HashMap<String,Integer> body = new HashMap<String,Integer>();
		ArrayList<ValuteCostanti> ls = new ArrayList<ValuteCostanti>();
		ObjectMapper obj = new ObjectMapper();
		
			body = obj.readValue(filtro,HashMap.class);


		
		for(String metodo: body.keySet()) {
			try {
				Class<?> Classefiltro = Class.forName("currency.scommettitoreApp.filtriEstatistiche.FiltraCostanti");
				Method method=Classefiltro.getMethod(metodo, HashMap.class, Integer.class);
				ls.addAll((ArrayList<ValuteCostanti>) method.invoke(Classefiltro,hs,body.get(metodo)));
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}

		return ls;
	}}

