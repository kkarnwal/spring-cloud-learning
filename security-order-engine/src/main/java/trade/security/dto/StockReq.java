package trade.security.dto;

/**
 * stock request dto
 *
 */
public class StockReq {

	private String name;
	private String id;

	/**
	 * represent last price of stock
	 */
	private double marketPrice;

	public StockReq(String name, String id) {
		this.name = name;
		this.id = id;
		this.marketPrice = 100;

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
