package jpmorgan.example.beans;

import jpmorgan.example.enums.StockName;
import jpmorgan.example.enums.StockType;

public class Share {

	private StockName stockName;
	private StockType stockType;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
	
	public StockName getStockName() {
		return stockName;
	}
	public void setStockName(StockName stockName) {
		this.stockName = stockName;
	}
	public StockType getStockType() {
		return stockType;
	}
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public Double getParValue() {
		return parValue;
	}
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	
	
}
