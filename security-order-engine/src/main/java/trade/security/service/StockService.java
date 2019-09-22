package trade.security.service;

import java.util.Collection;

import trade.security.dto.Stock;
import trade.security.dto.StockReq;

public interface StockService {

	Collection<Stock> getAllStock();

	Stock getStock(String id);

	void validate(String id);

	Stock addStock(StockReq req);
}
