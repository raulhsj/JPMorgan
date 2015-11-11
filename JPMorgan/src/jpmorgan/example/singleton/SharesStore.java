package jpmorgan.example.singleton;

import java.util.LinkedHashMap;
import java.util.Map;

import jpmorgan.example.beans.Share;
import jpmorgan.example.enums.StockName;
import jpmorgan.example.enums.StockType;

public class SharesStore {

	private static Map<StockName,Share> shareSet = new LinkedHashMap<StockName, Share>();
	
	static {
		Share share = new Share(); 
		share.setStockName(StockName.TEA);
		share.setStockType(StockType.COMMON);
		share.setLastDividend(0.0);
		share.setParValue(100.0);
		shareSet.put(StockName.TEA, share);
		
		share = new Share(); 
		share.setStockName(StockName.POP);
		share.setStockType(StockType.COMMON);
		share.setLastDividend(8.0);
		share.setParValue(100.0);
		shareSet.put(StockName.POP, share);
		
		share = new Share(); 
		share.setStockName(StockName.ALE);
		share.setStockType(StockType.COMMON);
		share.setLastDividend(23.0);
		share.setParValue(60.0);
		shareSet.put(StockName.ALE, share);
		
		share = new Share(); 
		share.setStockName(StockName.GIN);
		share.setStockType(StockType.PREFERRED);
		share.setLastDividend(8.0);
		share.setFixedDividend(2.0);
		share.setParValue(100.0);
		shareSet.put(StockName.GIN, share);
		
		share = new Share(); 
		share.setStockName(StockName.JOE);
		share.setStockType(StockType.COMMON);
		share.setLastDividend(13.0);
		share.setParValue(250.0);
		shareSet.put(StockName.TEA, share);
		
	}
	
	private SharesStore() {}
	
	
	public static Share getStock(StockName stockName) {
		// TODO Auto-generated method stub
		return shareSet.get(stockName);
	}


	public static Map<StockName, Share> getStore() {
		// TODO Auto-generated method stub		
		return shareSet;
	}

}
