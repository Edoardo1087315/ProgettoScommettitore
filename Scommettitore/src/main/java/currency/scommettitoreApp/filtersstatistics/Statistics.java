package currency.scommettitoreApp.filtersstatistics;

import java.util.Vector;

public class Statistics {

	public static double average(Vector<Double> vet) {

		double sum = 0;
		for (int i = 0; i < vet.size(); i++)
			sum += vet.get(i);
		return (double) sum / vet.size();

	}

	public static double variance(Vector<Double> vet) {
		double m = average(vet);
		double epsilon = 0;
		for (int i = 0; i < vet.size(); i++)
			epsilon += (vet.get(i) - m) * (vet.get(i) - m);
		return epsilon / vet.size();
	}

	public static double standardDeviation(Vector<Double> vet) {
		return Math.sqrt(variance(vet));
	}

	public static double percentageVariation(Vector<Double> vet) {
		double percentage_variation = 0.0;

		percentage_variation = ((vet.lastElement() - vet.firstElement()) / vet.firstElement()) * 100;
		return percentage_variation;
	}

	public static Vector<Double> dailyPercentageVariation(Vector<Double> vet) {
		Vector<Double> percentage_variation = new Vector<Double>();
		for (int i = 0; i < (vet.size() - 1); i++)
			percentage_variation.add((vet.elementAt(i + 1) - vet.elementAt(i)) / (vet.elementAt(i)) * 100);

		return percentage_variation;
	}

}
