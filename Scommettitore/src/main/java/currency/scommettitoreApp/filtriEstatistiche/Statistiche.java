package currency.scommettitoreApp.filtriEstatistiche;

import java.util.Vector;


public class Statistiche {


	public static double media(Vector<Double> vet) {

		double somma = 0;
		for (int i = 0; i < vet.size(); i++)
			somma += vet.get(i);
		return (double) somma / vet.size();

	}

	public static double varianza(Vector<Double> vet) {
		double m = media(vet);
		double sommaScartiQuad = 0;
		for (int i = 0; i < vet.size(); i++)
			sommaScartiQuad += (vet.get(i) - m) * (vet.get(i) - m);
		return sommaScartiQuad / vet.size();
	}

	public static double dev_Standard(Vector<Double> vet) {
		return Math.sqrt(varianza(vet));
	}

	public static double VariazPercentuale(Vector<Double> vet) {
		double variaz_percentuale = 0.0;

		variaz_percentuale = ((vet.lastElement() - vet.firstElement()) / vet.firstElement()) * 100;
		return variaz_percentuale;
	}

	public static Vector<Double> VariazPercentualeGiornaliera(Vector<Double> vet) {
		Vector<Double> variaz_percentuale = new Vector<Double>();
		for (int i = 0; i < (vet.size()-1);i++)
			variaz_percentuale.add((vet.elementAt(i+1) - vet.elementAt(i)) / (vet.elementAt(i)) * 100);

		return variaz_percentuale;
	}

}
