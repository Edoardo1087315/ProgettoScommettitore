package currency.scommettitoreApp.filtriEstatistiche;

import java.awt.List;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.lang.reflect.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.Ausiliare;
import currency.scommettitoreApp.model.Metodi;
import currency.scommettitoreApp.model.ModelloFiltro;
import currency.scommettitoreApp.model.ModelloValuta;

public class Filtri {

	public static ArrayList<Ausiliare> filtri(String filtro,HashMap<String,ModelloValuta> hs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		
		HashMap<String,Object> body = new HashMap<String,Object>();	
		ArrayList<Ausiliare> ls = null;
		ObjectMapper obj = new ObjectMapper();
		try {
			body = obj.readValue(filtro,HashMap.class);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		HashMap<String,Integer> metodi = new HashMap<String,Integer>();
		
		for(String campo: body.keySet()) {
			metodi = (HashMap<String, Integer>) body.get(campo);
			for(String metodo : metodi.keySet()) {
			String Metodo = metodo;
			Integer parametro = metodi.get(metodo);
			Class<?> typeClass;
			try {
				typeClass = Class.forName("currency.scommettitoreApp.filtriEstatistiche.Filtra"+campo);
				Constructor<?> constructor = typeClass.getConstructor();
				Object classe = constructor.newInstance();
				Method method=typeClass.getMethod(Metodo, HashMap.class, Integer.class, String.class);
				ls = (ArrayList<Ausiliare>) method.invoke(classe,hs,parametro, Metodo);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}
		
	
	

		}
		return ls;
	}}

