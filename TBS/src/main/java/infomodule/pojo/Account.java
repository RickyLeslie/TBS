package infomodule.pojo;

import java.io.Serializable;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String customer_id;  //客户ID
	private String bankAccount;  //银行卡号
	private String openBank;     //开户行
	private Double readyAmount;  //预存金额
	private Double costAmount;   //消费额
	private Double costMonthAmount;//当月消费额
	public Account() {
		super();
	}
	public Account(String id, String customer_id, String bankAccount, String openBank, Double readyAmount,
			Double costAmount, Double costMonthAmount) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.bankAccount = bankAccount;
		this.openBank = openBank;
		this.readyAmount = readyAmount;
		this.costAmount = costAmount;
		this.costMonthAmount = costMonthAmount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public Double getReadyAmount() {
		return readyAmount;
	}
	public void setReadyAmount(Double readyAmount) {
		this.readyAmount = readyAmount;
	}
	public Double getCostAmount() {
		return costAmount;
	}
	public void setCostAmount(Double costAmount) {
		this.costAmount = costAmount;
	}
	public Double getCostMonthAmount() {
		return costMonthAmount;
	}
	public void setCostMonthAmount(Double costMonthAmount) {
		this.costMonthAmount = costMonthAmount;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", customer_id=" + customer_id + ", bankAccount=" + bankAccount + ", openBank="
				+ openBank + ", readyAmount=" + readyAmount + ", costAmount=" + costAmount + ", costMonthAmount="
				+ costMonthAmount + "]";
	}
	
	

}
