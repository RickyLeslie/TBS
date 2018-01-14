package infomodule.pojo;

import java.io.Serializable;

public class Supplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String supplierName;
	private String telephone;
	public Supplier() {
		super();
	}
	public Supplier(String id, String supplierName, String telephone) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.telephone = telephone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", telephone=" + telephone + "]";
	}
	
	

}
