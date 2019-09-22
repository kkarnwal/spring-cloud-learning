package trade.security.service;

import java.util.List;

import trade.security.dto.Order;
import trade.security.dto.OrderBook;
import trade.security.dto.OrderBookDto;
import trade.security.dto.OrderRequest;

public interface OrderBookService {

	OrderBook getOrderBookByStock(String stockId);

//	OrderBook updateOrderBook(String stockId,Order order);
	OrderBook updateOrderBook(String stockId, OrderRequest order);

	OrderBook cancelOrder(String stockId, String orderId);

	List<Order> executeOrder(String stockId);

	OrderBookDto getAggregatedOrderBook(String stockId);

}
