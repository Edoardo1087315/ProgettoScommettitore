package currency.scommettitoreApp.plot;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.imageio.ImageIO;

import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.model.*;
import currency.scommettitoreApp.service.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {

	public static byte[] lineChart(HashMap<String, CurrencyModel> hs, String from, String to) throws DateException, ParseException{
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		Vector<String> date = DateService.dateRange(from, to);
		long period = DateService.getPeriod(from, to);
		Set<String> x = hs.keySet();
		for (String y : x) {
			Iterator<Double> it = hs.get(y).getValues().iterator();
			Iterator<String> it2 = date.iterator();
			for (int i = 0; i <= period; i++) {
				line_chart_dataset.addValue(it.next(), y, it2.next());
			}
		}

		JFreeChart lineChartObject = ChartFactory.createLineChart("Variazioni", "Date", "Valori", line_chart_dataset,
				PlotOrientation.VERTICAL, true, true, false);

		CategoryPlot plot = (CategoryPlot) lineChartObject.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		((NumberAxis) plot.getRangeAxis()).setAutoRangeIncludesZero(false);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		plot.setDomainGridlinesVisible(true);
		plot.setRangeGridlinesVisible(false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		BufferedImage image = lineChartObject.createBufferedImage(width, height);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "PNG", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();

	}

}