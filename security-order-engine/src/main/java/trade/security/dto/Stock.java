package trade.security.dto;

/**
 * stock entity
 *
 */
public class Stock {

	private String name;
	private String id;

	/**
	 * represent last price of stock
	 */
	private double marketPrice;

	public Stock(String name, double marketPrice) {
		this.name = name;
		this.marketPrice = marketPrice;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

}
