package currency.scommettitoreApp.service;

import java.io.IOException;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.ApiParsing;
import currency.scommettitoreApp.currencylayer.Currencylayer;

@org.springframework.stereotype.Service
public class PrincipalService {
	
	
	static Vector<ApiParsing> p = new Vector<ApiParsing>();
	
	public Vector<ApiParsing> CiclaDate(String from, String to) {
		if(from.equals("") || to.equals("")) {
			to = Data.DataOdierna();
			from = Data.ieri();
		}
		
		Vector<String> giorni = Data.DateRange(from,to);
		for(String x : giorni) {
			try {
				p.add(Currencylayer.GetJsonAndDecode(urlService.geturl(x)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
			
		}
	public Vector<String> ReturnStringFromApiParsing(ApiParsing p){
		Vector<String> vet = new Vector<String>();
		vet.addAll(p.quotes.keySet());
		return vet;
	}
	}

