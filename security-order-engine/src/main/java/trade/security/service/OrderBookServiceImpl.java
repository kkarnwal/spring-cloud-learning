package trade.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import trade.security.dto.Order;
import trade.security.dto.Order.OrderStatus;
import trade.security.dto.Order.OrderType;
import trade.security.dto.Order.TransactionType;
import trade.security.dto.OrderBook;
import trade.security.dto.OrderBookDto;
import trade.security.dto.OrderRequest;
import trade.security.dto.Stock;
import trade.security.utils.OrderBookDataHolder;
import trade.security.utils.OrderFactory;
import trade.security.utils.StockDataHolder;
import trade.security.utils.TradeUtils;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	@Override
	public OrderBook getOrderBookByStock(String stockId) {
		OrderBook orderBook = OrderBookDataHolder.getOrderBook(stockId);
		if (orderBook == null) {
			orderBook = OrderBookDataHolder.createOrderBook(stockId);
		}
		return orderBook;
	}

	@Override
	public OrderBook updateOrderBook(String stockId, OrderRequest orderReq) {
		orderReq.setId(TradeUtils.getUUId());
		orderReq.setStockId(stockId);

		OrderBook orderBook = OrderBookDataHolder.getOrderBook(stockId);
		if (orderBook == null) {
			orderBook = OrderBookDataHolder.createOrderBook(stockId);
		}
		Order order = OrderFactory.getOrder(orderReq);
		if (order.getType().equals(OrderType.MARKET)) {
			order.setPrice(StockDataHolder.getData(stockId).getMarketPrice());
		} else {
			double marketPrice = StockDataHolder.getData(stockId).getMarketPrice();
			if ((order.getTrxType().equals(TransactionType.BID) && order.getPrice() > marketPrice)
					|| (order.getTrxType().equals(TransactionType.ASK) && order.getPrice() < marketPrice)) {
				order.setPrice(marketPrice);
			}
		}
		System.out.println("order: " + order);
		orderBook.update(order);
		return orderBook;
	}

	@Override
	public OrderBook cancelOrder(String stockId, String orderId) {
		OrderBook orderBook = OrderBookDataHolder.getOrderBook(stockId);
		orderBook.cancelOrder(orderId);
		return orderBook;
	}

	@Override
	public List<Order> executeOrder(String stockId) {
		OrderBook orderBook = OrderBookDataHolder.getOrderBook(stockId);
		Set<Order> bids = orderBook.getBids();
		Set<Order> asks = orderBook.getAsks();
		Set<Order> executed = new HashSet<>();
		Iterator<Order> bidIterator = bids.iterator();
		Iterator<Order> askIterator = asks.iterator();
//		Map<Order,Order> executeResult= new HashMap<>(); 
		List<Order> executedOrders = new ArrayList<>();
		Order bid = null;
		Order ask = null;
		if (bidIterator.hasNext() && askIterator.hasNext()) {
			bid = bidIterator.next();
			ask = askIterator.next();
		}
		Stock stock = StockDataHolder.getData(stockId);
		System.out.println("1-bid:" + bid + " , ask:" + ask);

		while (bid != null && ask != null) {
			// if price is same whether limit or market order just execute
			if (bid.getType().equals(OrderType.MARKET) || ask.getType().equals(OrderType.MARKET)) { //
				if (bid.getQuantity() == ask.getQuantity()) {
					System.out.println("bid: " + bid.getId() + " , ask:" + ask.getId() + " --- matched");
					// both order price and quantity match so, can be marked as completed
					bid.setStatus(OrderStatus.COMPLETE);
					ask.setStatus(OrderStatus.COMPLETE);
					stock.setMarketPrice(ask.getPrice());

					executedOrders.add(bid);
					bidIterator.remove();
					executedOrders.add(ask);
					askIterator.remove();

					bid = bidIterator.hasNext() ? bidIterator.next() : null;
					ask = askIterator.hasNext() ? askIterator.next() : null;

				} else if (bid.getQuantity() > ask.getQuantity()) {
					System.out.println("bid: " + bid.getId() + " , ask:" + ask.getId() + " --- matched partially");
					ask.setStatus(OrderStatus.COMPLETE);
					executedOrders.add(ask);
					askIterator.remove();

					bid.setQuantity(bid.getQuantity() - ask.getQuantity());
					bid.setPrice(ask.getPrice());
					bid.setStatus(OrderStatus.PARTIALY_COMPLETE);
					stock.setMarketPrice(ask.getPrice());
					ask = askIterator.hasNext() ? askIterator.next() : null;

				} else { // ask quantity is higher
					System.out.println("bid: " + bid.getId() + " , ask:" + ask.getId() + " --- matched partially");
					bid.setStatus(OrderStatus.COMPLETE);
					executedOrders.add(bid);
					bidIterator.remove();

					ask.setQuantity(ask.getQuantity() - bid.getQuantity());
					ask.setStatus(OrderStatus.PARTIALY_COMPLETE);
					ask.setPrice(bid.getPrice());
					stock.setMarketPrice(ask.getPrice());

					bid = bidIterator.hasNext() ? bidIterator.next() : null;
				}
			} // price differ then check for bid X or lower and for ask X or higher
		}
		return executedOrders;
	}

	@Override
	public OrderBookDto getAggregatedOrderBook(String stockId) {
		OrderBook orderBookByStock = getOrderBookByStock(stockId);
		OrderBookDto response = new OrderBookDto();
		response.setStockName(StockDataHolder.getData(stockId).getName());
		response.aggregate(orderBookByStock);
		return response;
	}

}
