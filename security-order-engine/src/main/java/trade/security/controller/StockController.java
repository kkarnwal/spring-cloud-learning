package trade.security.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.security.dto.Stock;
import trade.security.dto.StockReq;
import trade.security.misc.ResourceNotFoundException;
import trade.security.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET, value = "/stocks", produces = "application/json")
	public ResponseEntity<Collection<Stock>> getAllStocks() {
		Collection<Stock> allStock = stockService.getAllStock();
		return new ResponseEntity<>(allStock, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/stocks/{id}")
	public ResponseEntity<Stock> getPoll(@PathVariable String id) {
		Stock stock = stockService.getStock(id);
		if (stock == null) {
			throw new ResourceNotFoundException("Invalid security id : " + id);
		}
		return new ResponseEntity<>(stock, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/stocks")
	public ResponseEntity<Stock> createOrder(@RequestBody StockReq req) {
		System.out.println("stock add req: " + req);
		Stock addStock = stockService.addStock(req);
		return new ResponseEntity<>(addStock, HttpStatus.OK);
	}
}
