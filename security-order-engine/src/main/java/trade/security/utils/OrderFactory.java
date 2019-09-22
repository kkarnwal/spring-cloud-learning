package trade.security.utils;

import java.util.Date;

import trade.security.dto.LimitOrder;
import trade.security.dto.MarketOrder;
import trade.security.dto.Order;
import trade.security.dto.Order.OrderType;
import trade.security.dto.Order.TransactionType;
import trade.security.dto.OrderRequest;

public class OrderFactory {

	
	public static Order getOrder(OrderRequest req) {
		Order order =  new Order();
		if(req.getType().equals(OrderType.LIMIT.getType())) {
			order.setPrice(req.getLimitPrice());
		}
		order.setId(req.getId());
		order.setType(OrderType.getOrderType(req.getType()));
		order.setTrxType(TransactionType.getTrxType(req.getTrxType()));
		order.setQuantity(req.getQuantity());
		order.setTimestamp(new Date());
		
//		if(req.getType().equals(OrderType.MARKET.getType())){
//			MarketOrder mo =  new MarketOrder();
//			mo.setId(req.getId());
//			mo.setType(OrderType.getOrderType(req.getType()));
//			mo.setTrxType(TransactionType.getTrxType(req.getTrxType()));
//			mo.setQuantity(req.getQuantity());
//			mo.setTimestamp(new Date());
//			mo.setMarketPrice(req.getLimitPrice());
//			return mo;
//		}else if(req.getType().equals(OrderType.LIMIT.getType())){
//			LimitOrder mo =  new LimitOrder();
//			mo.setId(req.getId());
//			mo.setType(OrderType.getOrderType(req.getType()));
//			mo.setTrxType(TransactionType.getTrxType(req.getTrxType()));
//			mo.setQuantity(req.getQuantity());
//			mo.setTimestamp(new Date());
//			mo.setLimitPrice(req.getLimitPrice());
//			return mo;
//		}
		return order;
	}
}

