package infomodule.pojo;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String customerName;  //客户名
	private String customerType;  //客户类型
	private String location;      //社区名
	private String manager;		  //行业经理
	private String industry;	  //所属行业
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Customer() {
		super();
	}
	public Customer(String id, String customerName, String customerType, String location, String manager,
			String industry) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerType = customerType;
		this.location = location;
		this.manager = manager;
		this.industry = industry;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerType=" + customerType
				+ ", location=" + location + ", manager=" + manager + ", industry=" + industry + "]";
	}
	
	

}
