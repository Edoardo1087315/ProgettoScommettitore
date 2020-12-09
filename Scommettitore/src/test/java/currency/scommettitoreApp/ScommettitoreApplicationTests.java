package currency.scommettitoreApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.filtersstatistics.Filter;
import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;
import currency.scommettitoreApp.service.DateService;

@SpringBootTest
class ScommettitoreApplicationTests {
	
	private Set<String> keys = null;
	private Vector<Double> v1 = null;
	private Vector<Double> v2 = null;
	private CurrencyModel m1 = null;
	private CurrencyModel m2 = null;
	private HashMap<String,CurrencyModel> hs = null;
	private ConstantCurrencyModel c1 = null;
	private ConstantCurrencyModel c2 = null;
	private ArrayList<ConstantCurrencyModel> f = null;
	private String from = null;
	private String to = null;
	
	@BeforeEach
	void setUp() throws Exception {
		keys = new HashSet<String>();
		v1 = new Vector<Double>();
		v2 = new Vector<Double>();
		hs = new HashMap<String,CurrencyModel>();
		c1 = new ConstantCurrencyModel();
		c2 = new ConstantCurrencyModel();
		f = new ArrayList<ConstantCurrencyModel>();
		
		from = "2020-12-09";
		to = "2020-12-07";
		
		keys.add("USDEUR");
		keys.add("USDBIF");
		
		v1.add(3.0);
		v1.add(2.0);
		v2.add(3.0);
		v2.add(7.0);
		
		m1 = new CurrencyModel(v1, 7.0,8.0,2.0,5.0,v2);
		m2 = new CurrencyModel(v2, 5.0,5.0,5.0,5.0,v2);
		
		hs.put("USDEUR", m1);
		hs.put("USDBIF", m2);
		
		c1.setCurrency("USDEUR");
		c1.setStandard_deviation(2.0);
		c2.setCurrency("USDBIF");
		c2.setStandard_deviation(5.0);
		
		f.add(c1);
		f.add(c2);
	}
	
	
	@AfterEach
	void tearDown() throws Exception {	
	}
	
	
	@Test
	void testStatistics() {
		assertEquals(keys, hs.keySet());
		assertEquals(7.0, hs.get("USDEUR").getAverage());
		assertEquals(5.0, hs.get("USDBIF").getAverage());
		assertEquals(8.0, hs.get("USDEUR").getVariance());
		assertEquals(5.0, hs.get("USDBIF").getVariance());
		assertEquals(v1, hs.get("USDEUR").getValues());
		assertEquals(v2, hs.get("USDBIF").getValues());
	}

	@Test
	void testFilter() {
		assertEquals(f.get(0).getStandard_deviation(), Filter.best(hs, 2).get(0).getStandard_deviation());
		assertEquals(f.get(1).getStandard_deviation(), Filter.best(hs, 2).get(1).getStandard_deviation());
		assertTrue(Filter.best(hs, 2).size()==2);
	}
	
	@Test
	void testExceptions() {
		assertThrows(DateException.class,()-> DateService.dateRange(from, to));
		assertThrows(ParseException.class,()-> DateService.dateVerify("--", "--"));
		}
}
