package jpmorgan.example.test;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import jpmorgan.example.SuperSimpleStockMarket;
import jpmorgan.example.beans.Trade;
import jpmorgan.example.enums.StockName;
import jpmorgan.example.enums.TradeIndicator;
import jpmorgan.example.singleton.TradeStore;

public class SuperSimpleStockMarketTest {

	private static SuperSimpleStockMarket calculator;
	
	@BeforeClass
	public static void initalize() {
		calculator = new SuperSimpleStockMarket();
	}
	@Test
	public void calculateDividendYield() {
		Double price = 558.5;
				
		Double dividendYield = calculator.calculateDividendYield(StockName.GIN, price);
		assertNotNull(dividendYield);
		
	}
	
	@Test
	public void calculatePERatio() {
		Double price = 558.5;
				
		Double peRatio = calculator.calculatePERatio(StockName.GIN, price);
		assertNotNull(peRatio);
		
	}
	
	@Test
	public void recordTrade() {
		TradeStore.store(StockName.ALE, Calendar.getInstance().getTime(), 12, TradeIndicator.SELL, 2500.35);
		Map<StockName, List<Trade>> tradeStore = TradeStore.getStore();
		assertNotNull(tradeStore.get(StockName.ALE));
		
	}
	
	@Test
	public void calculateVWSP() {
		calculator.calculateVWSP(StockName.GIN);
	}
	
	@Test
	public void calculateGBCE() {
		List<Double> listPrices = new LinkedList<Double>();
		listPrices.add(100.0);listPrices.add(100.0);listPrices.add(100.0);listPrices.add(100.0);listPrices.add(100.0);
		Double result = calculator.calculateVWSP(listPrices);
		assertNotNull(result);
	}
}
