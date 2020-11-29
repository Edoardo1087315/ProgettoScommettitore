package currency.scommettitoreApp.filtriEstatistiche;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.reflect.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.Ausiliare;
import currency.scommettitoreApp.model.ModelloValuta;

public class Filtri {

	public static ArrayList<Ausiliare> filtri(String filtro,HashMap<String,ModelloValuta> hs) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		HashMap<String,Integer> body = new HashMap<String,Integer>();
		ArrayList<Ausiliare> ls = new ArrayList<Ausiliare>();
		ObjectMapper obj = new ObjectMapper();
		
		try {
			body = obj.readValue(filtro,HashMap.class);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		
		for(String metodo: body.keySet()) {
			try {
				Class<?> Classefiltro = Class.forName("currency.scommettitoreApp.filtriEstatistiche.FiltraCostanti");
				Constructor<?> constructor = Classefiltro.getConstructor();
				Object classe = constructor.newInstance();
				Method method=Classefiltro.getMethod(metodo, HashMap.class, Integer.class);
				ls.addAll((ArrayList<Ausiliare>) method.invoke(classe,hs,body.get(metodo)));
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}

		return ls;
	}}

