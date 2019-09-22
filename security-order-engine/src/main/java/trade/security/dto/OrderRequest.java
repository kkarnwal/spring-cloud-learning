package trade.security.dto;

import java.util.Date;

import trade.security.utils.TradeUtils;

/**
 * represent request dto for order which can be different type Market or LIMIT
 *
 */
//@json
public class OrderRequest {

	private String id;
	private String stockId;
	private String type;
	private String trxType;
    private Date timestamp;
	private int quantity;
	private double limitPrice;
	
	public OrderRequest() {
		timestamp = new Date();
		id=TradeUtils.getUUId();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTrxType() {
		return trxType;
	}
	public void setTrxType(String trxType) {
		this.trxType = trxType;
	}
	public double getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Override
	public String toString() {
		return "OrderRequest [id=" + id + ", type=" + type + ", trxType=" + trxType + ", timestamp=" + timestamp
				+ ", quantity=" + quantity + ", limitPrice=" + limitPrice + ", stockId="+stockId+"]";
	}
	
	 

}
