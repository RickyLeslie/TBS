package infomodule.pojo;

import java.io.Serializable;

public class Phone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telephone; //电话号码
	private String address;   //地址
	private String bankAccount;//银行卡号
	private String password;
	public Phone() {
		super();
	}
	public Phone(String telephone, String address, String bankAccount,String password) {
		super();
		this.telephone = telephone;
		this.address = address;
		this.bankAccount = bankAccount;
		this.password=password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Phone [telephone=" + telephone + ", address=" + address + ", bankAccount=" + bankAccount + ", password="
				+ password + "]";
	}
	
	
	
}
