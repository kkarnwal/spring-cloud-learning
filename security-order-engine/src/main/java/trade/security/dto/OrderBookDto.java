package trade.security.dto;

import java.util.Map;
import java.util.TreeMap;

public class OrderBookDto {

	private String stockId;
	private String stockName;

	private Map<Double, Integer> asks = new TreeMap<>();
	private Map<Double, Integer> bids = new TreeMap<>();

	public OrderBookDto() {

	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Map<Double, Integer> getAsks() {
		return asks;
	}

	public Map<Double, Integer> getBids() {
		return bids;
	}

	public void aggregate(OrderBook orderBook) {
		setStockId(orderBook.getStockId());
//		setStockId(orderBook.getStockId());
		orderBook.getAsks().forEach(order -> {
			if (asks.get(order.getPrice()) == null) {
				asks.put(order.getPrice(), order.getQuantity());
			} else {
				asks.put(order.getPrice(), asks.get(order.getPrice()) + order.getQuantity());
			}
		});

		orderBook.getBids().forEach(order -> {
			if (bids.get(order.getPrice()) == null) {
				bids.put(order.getPrice(), order.getQuantity());
			} else {
				bids.put(order.getPrice(), bids.get(order.getPrice()) + order.getQuantity());
			}
		});

	}
}
