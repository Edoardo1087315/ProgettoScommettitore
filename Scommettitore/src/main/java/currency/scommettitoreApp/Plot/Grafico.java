package currency.scommettitoreApp.Plot;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.imageio.ImageIO;

import currency.scommettitoreApp.model.*;
import currency.scommettitoreApp.service.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Grafico {
	
	static final int DAY = (24*60*60*1000);

   public static byte[] GraficoLineare(HashMap<String,ModelloValuta> hs2, String from, String to) throws Exception {
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      Vector<String> date = DataService.DateRange(from, to);
      long periodo = DataService.getPeriodo(from,to);
      Set<String> x = hs2.keySet(); 
      for(String y : x) {
    	  Iterator<Double> it = hs2.get(y).getValori().iterator();
    	  Iterator<String> it2 = date.iterator();
     	  for(int i = 0; i<=periodo; i++) {
    	 line_chart_dataset.addValue(it.next(), y, it2.next());
    	 }
      }
      
    
      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "Variazioni","Date",
         "Valori",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,false);    
      
      CategoryPlot plot = (CategoryPlot) lineChartObject.getPlot();
      plot.getRangeAxis().setAutoRange(true);                  
      ((NumberAxis)plot.getRangeAxis()).setAutoRangeIncludesZero(false);
      plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
    		plot.setDomainGridlinesVisible(true);
    		plot.setRangeGridlinesVisible(false);
      
      int width = 640;    /* Width of the image */
      int height = 480;   /* Height of the image */ 
      BufferedImage image = lineChartObject.createBufferedImage(width, height);

      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(image, "PNG", baos);
      return baos.toByteArray();

      
   }
   
   
   
   
}