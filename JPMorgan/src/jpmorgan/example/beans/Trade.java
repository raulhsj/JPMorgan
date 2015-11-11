package jpmorgan.example.beans;

import java.util.Date;

import jpmorgan.example.enums.TradeIndicator;

public class Trade {

	private Date tmStampTrade;
	private Integer numShares;
	private TradeIndicator tradeIndicator;
	private Double tradedPrice;
	
	public Date getTmStampTrade() {
		return tmStampTrade;
	}
	public void setTmStampTrade(Date tmStampTrade) {
		this.tmStampTrade = tmStampTrade;
	}
	public Integer getNumShares() {
		return numShares;
	}
	public void setNumShares(Integer numShares) {
		this.numShares = numShares;
	}
	public TradeIndicator getTradeIndicator() {
		return tradeIndicator;
	}
	public void setTradeIndicator(TradeIndicator tradeIndicator) {
		this.tradeIndicator = tradeIndicator;
	}
	public Double getTradedPrice() {
		return tradedPrice;
	}
	public void setTradedPrice(Double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}
	
	
}
