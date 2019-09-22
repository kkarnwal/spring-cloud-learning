package trade.security.dto;

import java.util.Comparator;

public class AskComparator implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		System.out.println(o1.getPrice() +" : "+o2.getPrice());
		return o1.getPrice() >= o2.getPrice() ? 1 : -1;
	}

}
