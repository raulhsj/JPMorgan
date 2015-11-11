package jpmorgan.example;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jpmorgan.example.beans.Share;
import jpmorgan.example.beans.Trade;
import jpmorgan.example.enums.StockName;
import jpmorgan.example.enums.StockType;
import jpmorgan.example.singleton.SharesStore;
import jpmorgan.example.singleton.TradeStore;

public class SuperSimpleStockMarket {

	public Double calculateDividendYield(StockName stockName, Double price) {
		// TODO Auto-generated method stub
		
		Share retrievedShare = SharesStore.getStock(stockName);
		
		StockType stockType = retrievedShare.getStockType();
		Double dividendYield = null;
		if(StockType.COMMON == stockType) {
			Double lastDividend = retrievedShare.getLastDividend();
			if(lastDividend != null && price != null) {				
				dividendYield = lastDividend / price;
			}
		} else if(StockType.PREFERRED == stockType) {
			Double fixedDividend = retrievedShare.getFixedDividend();
			Double parValue = retrievedShare.getParValue();
			if(fixedDividend != null && parValue != null && price != null) {
				dividendYield = (fixedDividend * parValue)/ price;
			}
		}
		
		return dividendYield;
		
	}

	public Double calculatePERatio(StockName stockName, Double price) {
		// TODO Auto-generated method stub
		Double dividend = calculateDividendYield(stockName, price);
		
		Double peRatio = null;
		if(dividend != null && price != null) {
			peRatio = price / dividend;
		}
		return peRatio;
	}

	public Double calculateVWSP(StockName stockName) {
		// TODO Auto-generated method stub
		//Based on trades in past 15 minutes
		Calendar cal = Calendar.getInstance();
		Long currentTimeMs = cal.getTimeInMillis();
		Map<StockName, List<Trade>> tradeStore = TradeStore.getStore();
		List<Trade> trades = tradeStore.get(stockName);
		Long tradeTimeMs = null;
		Double sumTradedPrice = 0.0;
		Integer sumQuantity = 0;
		if(trades != null)
			for(Trade trade: trades) {
				Date tradeTmstamp = trade.getTmStampTrade();
				cal.setTime(tradeTmstamp);
				tradeTimeMs = cal.getTimeInMillis();
				if((currentTimeMs - tradeTimeMs) == 54000) {
					sumQuantity += trade.getNumShares();
					sumTradedPrice += (trade.getTradedPrice() * trade.getNumShares());
				}
			}
		return sumTradedPrice/sumQuantity;
	}

	public Double calculateVWSP(List<Double> listPrices) {
		// TODO Auto-generated method stub
		Map<StockName,Share> store = SharesStore.getStore();
		Double result = 0.0;
		if(listPrices != null && (store.size() == listPrices.size())) {
			for(Double price: listPrices) {
				result *= price;
			}
			result = Math.pow(result, (1/listPrices.size()));
		}
		return result;
	}

}