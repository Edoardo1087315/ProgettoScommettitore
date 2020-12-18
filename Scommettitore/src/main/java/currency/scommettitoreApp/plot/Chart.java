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

/**
 * Classe che crea il grafico
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class Chart {

	/**
	 * Metodo che crea il grafico di linea 
	 * @param hs la HashMap precedentemente creata e popolata
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @return un vettore di byte che visualizza il grafico
	 * @throws DateException
	 * @throws ParseException
	 * @see currency.scommettitoreApp.service.DateService
	 */
	
	public static byte[] lineChart(HashMap<String, CurrencyModel> hs, String from, String to) throws DateException, ParseException{
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();  //creo un dataset nel quale andrò ad inserire i valori
		Vector<String> date = DateService.dateRange(from, to);	//le date andranno sull'asse delle X
		long period = DateService.getPeriod(from, to);
		Set<String> x = hs.keySet(); //il keySet di hs contiene tutte le valute che voglio graficare, se non inserito il parametro currencies, di default contiene solo "EUR"
		for (String y : x) {
			Iterator<Double> it = hs.get(y).getValues().iterator();
			Iterator<String> it2 = date.iterator();
			for (int i = 0; i <= period; i++) {
				line_chart_dataset.addValue(it.next(), y, it2.next()); //aggiungo al dataset i valori assunti nel tempo dalle valute
			}
		} 

		JFreeChart lineChartObject = ChartFactory.createLineChart("Variazioni", "Date", "Valori", line_chart_dataset,
				PlotOrientation.VERTICAL, true, true, false); //creo un grafico lineare con il metodo createLineChart, è possibile specificare se mostrare la legenda, tooltips e urls 
		
		
		CategoryPlot plot = (CategoryPlot) lineChartObject.getPlot(); //per andare a personalizzare il grafico ho bisogno di un oggetto della classse CategoryPlot
		plot.getRangeAxis().setAutoRange(true); 					  //imposto autorange degli assi, in questo modo la risoluzione del grafico è maggiore 
		((NumberAxis) plot.getRangeAxis()).setAutoRangeIncludesZero(false); //devo dire al plot che non deve contenere lo 0 altrimenti sarà sempre visibile sul grafico e la risoluzione di quest'ultimo risulta meno valida
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45); //i valori scritti sugli assi hanno un angolo di 45 gradi cosi da essere visibili anche su periodi lunghi
		plot.setDomainGridlinesVisible(true); //inoltre genero anche la griglia sul grafico in questo modo sarà più semplice consultarlo
		plot.setRangeGridlinesVisible(true);

		int width = 640; 
		int height = 480; 
		BufferedImage image = lineChartObject.createBufferedImage(width, height); 

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //creo un output stream che mi servira per scrivere un array di byte
		try {
			ImageIO.write(image, "PNG", baos); //l'immagine viene letta e sarà trascritta sul outpustream baos con formato "PNG"
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray(); 
		

	}

}