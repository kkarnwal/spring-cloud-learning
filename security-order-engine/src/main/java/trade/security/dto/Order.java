package trade.security.dto;

import java.util.Date;

import trade.security.utils.TradeUtils;

public class Order {

	public enum OrderType {

		MARKET("MARKET"), LIMIT("LIMIT");

		private String type;

		public String getType() {
			return type;
		}

		public static OrderType getOrderType(String val) {
			for (OrderType oType : OrderType.values()) {
				if (oType.getType().equals(val)) {
					return oType;
				}
			}
			return null;
		}

		OrderType(String type) {
			this.type = type;
		}

	}

	public enum TransactionType {
		BID("BID"), ASK("ASK");

		private String type;

		public String getType() {
			return type;
		}

		public static TransactionType getTrxType(String val) {
			for (TransactionType oType : TransactionType.values()) {
				if (oType.getType().equals(val)) {
					return oType;
				}
			}
			return null;
		}

		TransactionType(String type) {
			this.type = type;
		}
	}

	public enum OrderStatus {
		PENDING, CANCELLED, COMPLETE, PARTIALY_COMPLETE;
	}

	public Order() {
		id = TradeUtils.getUUId();
		timestamp = new Date();
		status = OrderStatus.PENDING;
	}

	private String id;
	private OrderType type;
	private TransactionType trxType;
	private Date timestamp;
	private int quantity;
	private OrderStatus status;
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
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

	public TransactionType getTrxType() {
		return trxType;
	}

	public void setTrxType(TransactionType trxType) {
		this.trxType = trxType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [ id=" + id + ",status=" + status + ", type=" + type + ", trxType=" + trxType + ", timestamp="
				+ timestamp + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public boolean isLimitOrder() {
		return type.equals(OrderType.LIMIT);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
