package currency.scommettitoreApp.model;

import java.util.Vector;

import currency.scommettitoreApp.filtersstatistics.Statistics;

public class CurrencyModel {

	private Vector<Double> values;

	private Double average;

	private Double variance;

	private Double standard_deviation;

	private Double percentage_variation;

	private Vector<Double> daily_percentage_variation;

	public CurrencyModel(Vector<Double> vet) {
		values = vet;
	}
	
	public void setStatistics() {
		average = Statistics.average(this.values);
		variance = Statistics.variance(this.values);
		standard_deviation = Statistics.standardDeviation(this.values);
		percentage_variation = Statistics.percentageVariation(this.values);
		daily_percentage_variation = Statistics.dailyPercentageVariation(this.values);
	}

	public Vector<Double> getValues() {
		return values;
	}

	public void setValues(Vector<Double> values) {
		this.values = values;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getVariance() {
		return variance;
	}

	public void setVariance(Double variance) {
		this.variance = variance;
	}

	public Double getStandard_deviation() {
		return standard_deviation;
	}

	public void setStandard_deviation(Double standard_deviation) {
		this.standard_deviation = standard_deviation;
	}

	public Double getPercentage_variation() {
		return percentage_variation;
	}

	public void setPercentage_variation(Double percentage_variation) {
		this.percentage_variation = percentage_variation;
	}

	public Vector<Double> getDaily_percentage_variation() {
		return daily_percentage_variation;
	}

	public void setDaily_percentage_variation(Vector<Double> daily_percentage_variation) {
		this.daily_percentage_variation = daily_percentage_variation;
	}

}
