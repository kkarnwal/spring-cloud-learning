package trade.security.utils;

import java.util.HashMap;
import java.util.Map;

import trade.security.dto.Order;
import trade.security.dto.OrderBook;
import trade.security.dto.Stock;

public class OrderBookDataHolder {

	static Map<String, OrderBook> data = new HashMap<>();
	
	
	public static void updateOrderData(OrderBook orderBook,String stockId) {
		data.put(stockId, orderBook);
	}


	public static OrderBook getOrderBook(String id) {
		return data.get(id);
	}


	public static OrderBook createOrderBook(String stockId) {
		OrderBook book = new OrderBook(stockId);
		updateOrderData(book, stockId);
		return book;
	}
	
	
}
