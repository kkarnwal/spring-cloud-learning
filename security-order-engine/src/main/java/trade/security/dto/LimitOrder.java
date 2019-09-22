package trade.security.dto;

public class LimitOrder extends Order {

	private double limitPrice;
	

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	@Override
	public String toString() {
		return "LimitOrder ["+super.toString()+" , limitPrice=" + limitPrice + "]";
	}
	
	
}
