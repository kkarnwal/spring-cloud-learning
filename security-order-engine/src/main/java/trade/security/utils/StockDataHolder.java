package trade.security.utils;

import java.util.HashMap;
import java.util.Map;

import trade.security.dto.Stock;

public class StockDataHolder {

	static Map<String, Stock> data = new HashMap<>();

	public static void loadData() {
		Stock stock = new Stock("HAL", 100);
		addStock(stock);

	}

	public static Map<String, Stock> getData() {
		return data;
	}

	public static Stock getData(String stockId) {
		return data.get(stockId);
	}

	public static void addStock(Stock stock) {
		stock.setId(TradeUtils.getUUId());
		data.put(stock.getId(), stock);
	}
}
