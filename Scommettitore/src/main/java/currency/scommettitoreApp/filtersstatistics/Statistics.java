package currency.scommettitoreApp.filtersstatistics;

import java.util.Vector;

/**
 * Classe per il calcolo delle statistiche
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class Statistics {

	/**
	 * Metodo per il calcolo della media
	 * @param vet Vector di Double con tutti i valori di ogni singola valuta su cui calcolare la media
	 * @return un Double rappresentante il valore medio
	 */
	
	public static double average(Vector<Double> vet) {

		double sum = 0;
		for (int i = 0; i < vet.size(); i++)
			sum += vet.get(i);
		return (double) sum / vet.size();

	}

	/**
	 * Metodo per il calcolo della varianza
	 * @param vet Vector di Double con tutti i valori di ogni singola valuta su cui calcolare la varianza
	 * @return un Double rappresentante il valore della varianza
	 */
	
	public static double variance(Vector<Double> vet) {
		double m = average(vet);
		double epsilon = 0;
		for (int i = 0; i < vet.size(); i++)
			epsilon += (vet.get(i) - m) * (vet.get(i) - m);
		return epsilon / vet.size();
	}

	/**
	 * Metodo per il calcolo della deviazione standard
	 * @param vet Vector di Double con tutti i valori di ogni singola valuta su cui calcolare la deviazione standard
	 * @return un Double rappresentante il valore della deviazione standard
	 */
	
	public static double standardDeviation(Vector<Double> vet) {
		return Math.sqrt(variance(vet));
	}

	/**
	 * Metodo per il calcolo della variazione percentuale
	 * @param vet Vector di Double con tutti i valori di ogni singola valuta su cui calcolare la variazione percentuale
	 * @return un Double rappresentante il valore della variazione percentuale
	 */
	
	public static double percentageVariation(Vector<Double> vet) {
		double percentage_variation = 0.0;
		percentage_variation = ((vet.lastElement() - vet.firstElement()) / vet.firstElement()) * 100;
		return percentage_variation;
	}

	/**
	 * Metodo per il calcolo delle veriazioni percentuali giornaliere
	 * @param vet Vector di Double con tutti i valori di ogni singola valuta su cui calcolare le variazioni percentuali giornaliere
	 * @return un Vector di Double rappresentante i valori delle variazioni percentuali giornaliere
	 */
	
	public static Vector<Double> dailyPercentageVariation(Vector<Double> vet) {
		Vector<Double> percentage_variation = new Vector<Double>();
		for (int i = 0; i < (vet.size() - 1); i++)
			percentage_variation.add((vet.elementAt(i + 1) - vet.elementAt(i)) / (vet.elementAt(i)) * 100);
		return percentage_variation;
	}

}
