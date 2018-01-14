package infomodule.pojo;

import java.io.Serializable;

public class Sale implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String customerType; //客户类型
	private Double discount;   //折扣
	public Sale() {
		super();
	}
	public Sale(String id, String customerType, Double discount) {
		super();
		this.id = id;
		this.customerType = customerType;
		this.discount = discount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", customerType=" + customerType + ", discount=" + discount + "]";
	}
	
	
}
