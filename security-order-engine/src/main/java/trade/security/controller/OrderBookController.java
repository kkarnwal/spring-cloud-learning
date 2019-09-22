package trade.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.security.dto.Order;
import trade.security.dto.OrderBook;
import trade.security.dto.OrderBookDto;
import trade.security.dto.OrderRequest;
import trade.security.service.OrderBookService;
import trade.security.service.StockService;

@RequestMapping("/stocks")
@RestController
public class OrderBookController {

	@Autowired
	private OrderBookService orderBookService;

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET, value = "/{stockId}/order-book-aggregate")
	public ResponseEntity<OrderBookDto> getOrderBookAggregate(@PathVariable String stockId) {

		stockService.validate(stockId);

		OrderBookDto response = orderBookService.getAggregatedOrderBook(stockId);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{stockId}/order-book")
	public ResponseEntity<OrderBook> getOrderBook(@PathVariable String stockId) {

		stockService.validate(stockId);
		OrderBook orderBookByStock = orderBookService.getOrderBookByStock(stockId);
		return new ResponseEntity<>(orderBookByStock, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{stockId}/order-book")
	public ResponseEntity<OrderBook> createOrder(@PathVariable String stockId, @RequestBody OrderRequest req) {
		stockService.validate(stockId);
		System.out.println("req: " + req);
		OrderBook updateOrderBook = orderBookService.updateOrderBook(stockId, req);
		return new ResponseEntity<>(updateOrderBook, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{stockId}/order-book/{orderId}")
	public ResponseEntity<OrderBook> amendOrder(@PathVariable String stockId, @PathVariable String orderId,
			@RequestBody OrderRequest req) {
		System.out.println("req: " + req);
		OrderBook updateOrderBook = orderBookService.updateOrderBook(stockId, req);
		return new ResponseEntity<>(updateOrderBook, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{stockId}/order-book/{orderId}")
	public ResponseEntity<Void> cacelOrder(@PathVariable String stockId, @PathVariable String orderId) {
		System.out.println("order delete req stockId= " + stockId + " ,orderId=" + orderId);
		OrderBook updateOrderBook = orderBookService.cancelOrder(stockId, orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{stockId}/order-book/match")
	public ResponseEntity<List<Order>> matchOrder(@PathVariable String stockId) {
		System.out.println("order match req stockId= " + stockId);
		List<Order> orders = orderBookService.executeOrder(stockId);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

}
