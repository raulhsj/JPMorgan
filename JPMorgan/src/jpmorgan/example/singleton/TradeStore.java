package jpmorgan.example.singleton;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jpmorgan.example.beans.Trade;
import jpmorgan.example.enums.StockName;
import jpmorgan.example.enums.TradeIndicator;

public class TradeStore {

	private static Map<StockName,List<Trade>> tradeSet = new LinkedHashMap<StockName, List<Trade>>();

	public static void store(StockName stockName, Date tmStampTrade, Integer numShares, TradeIndicator tradeIndicator, Double tradedPrice) {
		// TODO Auto-generated method stub
		Trade trade = new Trade();
		trade.setNumShares(numShares);
		trade.setTmStampTrade(tmStampTrade);
		trade.setTradeIndicator(tradeIndicator);
		trade.setTradedPrice(tradedPrice);
		List<Trade> listTrades = tradeSet.get(stockName);
		if(listTrades == null) {
			listTrades = new LinkedList<Trade>();
		}
		listTrades.add(trade);
		tradeSet.put(stockName, listTrades);
		
		
	}
	
	public static Map<StockName, List<Trade>> getStore() {
		return tradeSet;
	}
	
	
}
