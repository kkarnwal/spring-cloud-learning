package trade.security.service;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import trade.security.dto.Stock;
import trade.security.dto.StockReq;
import trade.security.misc.ResourceNotFoundException;
import trade.security.utils.StockDataHolder;

@Service
public class StockServiceImpl implements StockService {

	@PostConstruct
	public void init() {
		StockDataHolder.loadData();
	}

	@Override
	public Collection<Stock> getAllStock() {
		return StockDataHolder.getData().values();
	}

	@Override
	public Stock getStock(String id) {
		Stock stock = StockDataHolder.getData().get(id);
		return stock;
	}

	@Override
	public void validate(String id) {
		// TODO Auto-generated method stub
		if (!StockDataHolder.getData().keySet().contains(id)) {
			throw new ResourceNotFoundException("Invalid security id : " + id);
		}
	}

	@Override
	public Stock addStock(StockReq req) {
		Stock stock = new Stock(req.getName(), req.getMarketPrice());

		StockDataHolder.addStock(stock);
		return stock;
	}

}
