package trade.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import trade.security.dto.Order;
import trade.security.dto.OrderBook;
import trade.security.dto.OrderBookDto;
import trade.security.dto.OrderRequest;
import trade.security.dto.Stock;
import trade.security.service.OrderBookService;
import trade.security.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SecurityOrderEngineApplicationTests {

	@Autowired
	private StockService service;
	@Autowired
	private OrderBookService bookService;

	@Test
	public void testStockList() {
		// all stock api
		Collection<Stock> allStock = service.getAllStock();
		assertNotNull(allStock);
		allStock.forEach(stock -> {
			assertNotNull(stock.getId());
			assertNotNull(stock.getName());
		});
		// get stock particular
		Stock expected = allStock.iterator().next();
		Stock actual = service.getStock(expected.getId());
		assertEquals("stock id does not match", expected.getId(), actual.getId());
	}

	@Test
	public void testGetOrderBookByStock() {
		Stock stock = service.getAllStock().iterator().next();
		OrderBook orderBookByStock = bookService.getOrderBookByStock(stock.getId());
		assertNotNull(orderBookByStock);
		assertEquals("stock id does not match", stock.getId(), orderBookByStock.getStockId());

	}

	@Test
	public void testCreateOrder() {
		Stock stock = service.getAllStock().iterator().next();
		OrderBook orderBookByStock = bookService.getOrderBookByStock(stock.getId());
		assertNotNull(orderBookByStock);
//		assertEquals("asks should be empty."expected, actual);
		assertEquals("stock id does not match", stock.getId(), orderBookByStock.getStockId());
		OrderRequest req = getOrderMarket("MARKET", "BID", 12);
		bookService.updateOrderBook(stock.getId(), req);
		orderBookByStock = bookService.getOrderBookByStock(stock.getId());
		assertNotNull(orderBookByStock);
		assertTrue(orderBookByStock.getBids().size() == 1);

		OrderRequest limitOrder = getOrderLimit("LIMIT", "BID", 2, 98);
		bookService.updateOrderBook(stock.getId(), limitOrder);
		orderBookByStock = bookService.getOrderBookByStock(stock.getId());
		assertNotNull(orderBookByStock);
		assertTrue(orderBookByStock.getBids().size() == 2);

		req = getOrderMarket("MARKET", "BID", 8);
		bookService.updateOrderBook(stock.getId(), req);

	}

	@Test
	public void testGetOrderBookAggregate() {
		Stock stock = service.getAllStock().iterator().next();

		OrderBookDto aggregatedOrderBook = bookService.getAggregatedOrderBook(stock.getId());

		assertNotNull(aggregatedOrderBook);
	}

	@Test
	public void testGetOrderBookCancelOrder() {
		Stock stock = service.getAllStock().iterator().next();
		OrderBook orderBookByStock = bookService.getOrderBookByStock(stock.getId());

		assertNotNull(orderBookByStock);

		OrderRequest req = getOrderMarket("MARKET", "BID", 12);
		OrderBook updateOrderBook = bookService.updateOrderBook(stock.getId(), req);
		int budCount = updateOrderBook.getBids().size();
		Order cancelOrder = updateOrderBook.getBids().iterator().next();
		updateOrderBook = bookService.cancelOrder(stock.getId(), cancelOrder.getId());
		assertEquals(budCount - 1, updateOrderBook.getBids().size());
	}

	@Test
	public void testGetOrderBookMatch() {

		Stock stock = service.getAllStock().iterator().next();
		OrderBook orderBookByStock = bookService.getOrderBookByStock(stock.getId());
		OrderRequest req = getOrderMarket("MARKET", "BID", 10);
		OrderBook updateOrderBook = bookService.updateOrderBook(stock.getId(), req);
		req = getOrderMarket("MARKET", "ASK", 10);
		List<Order> executeOrder = bookService.executeOrder(stock.getId());
		assertNotNull(executeOrder);

	}

	private OrderRequest getOrderMarket(String type, String trxType, int quantity) {
		OrderRequest order = new OrderRequest();
		order.setQuantity(quantity);
		order.setType(type);
		order.setTrxType(trxType);
		return order;
	}

	private OrderRequest getOrderLimit(String type, String trxType, int quantity, double Limitrice) {
		OrderRequest order = new OrderRequest();
		order.setQuantity(quantity);
		order.setType(type);
		order.setTrxType(trxType);
		order.setLimitPrice(Limitrice);

		return order;
	}

}
