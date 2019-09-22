package trade.security.dto;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import trade.security.dto.Order.TransactionType;

public class OrderBook {

	private Date timeStamp;
	private String stockId;

	/**
	 * the asks
	 */
	private Set<Order> asks;

	/**
	 * the bids
	 */
	private Set<Order> bids;

	public OrderBook(String id) {
		stockId = id;
		timeStamp = new Date();
		asks = new TreeSet<>(new AskComparator());// Comparator.comparing(Order::getPrice));
		bids = new TreeSet<>(new BidComparator());// Comparator.comparing(Order::getPrice).reversed());
	}

	public OrderBook(Date timeStamp, Set<Order> asks, Set<Order> bids) {

		this.timeStamp = timeStamp;
		this.asks = asks;
		this.bids = bids;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Set<Order> getAsks() {
		return asks;
	}

	public Set<Order> getBids() {
		return bids;
	}

	public Set<Order> getOrders(TransactionType type) {
		System.out.println("get order:" + type + " flag:" + (type == TransactionType.ASK));
		return type == TransactionType.ASK ? asks : bids;
	}

	public void update(Order limitOrder) {
		Set<Order> orders = getOrders(limitOrder.getTrxType());
		System.out.println("total orders:" + orders);
		orders.add(limitOrder);
	}

	public String getStockId() {
		return stockId;
	}

	@Override
	public String toString() {
		return "OrderBook [timeStamp=" + timeStamp + ", stockId=" + stockId + ", asks=" + asks + ", bids=" + bids + "]";
	}

	public void cancelOrder(String orderId) {
		Iterator<Order> iterator = asks.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId().equals(orderId)) {
				System.out.println("order found in asks: " + orderId);
				iterator.remove();
				break;
			}
		}
		iterator = bids.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId().equals(orderId)) {
				System.out.println("order found in bids: " + orderId);
				iterator.remove();
				break;
			}
		}

		/*
		 * Optional<Order> askOrder = asks.stream().filter(order ->
		 * order.getId().equals(orderId)).findFirst(); if (askOrder.isPresent()) {
		 * System.out.println("order found in asks: " + askOrder.get());
		 * asks.remove(askOrder.get()); }
		 * 
		 * Optional<Order> bidOrder = bids.stream().filter(order ->
		 * order.getId().equals(orderId)).findFirst(); if (bidOrder.isPresent()) {
		 * System.out.println("order found in bids: " + bidOrder.get());
		 * bids.remove(bidOrder.get()); }
		 */
	}

}
