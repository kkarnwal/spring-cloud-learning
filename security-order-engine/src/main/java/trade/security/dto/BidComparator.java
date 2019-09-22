package trade.security.dto;

import java.util.Comparator;

public class BidComparator implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		return o1.getPrice() <= o2.getPrice() ? 1 : -1;
		//(x < y) ? -1 : ((x == y) ? 0 : 1);
	}

}
