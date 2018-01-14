package infomodule.pojo;

import java.io.Serializable;

public class Bill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;   //账单号
	private String MUID; //主叫号
	private String CUID; //被叫号
	private Integer callDuration;  //通讯时长
	private Double telephoneCharge;//话费
	public Bill() {
		super();
	}
	public Bill(String id, String mUID, String cUID, Integer callDuration, Double telephoneCharge) {
		super();
		this.id = id;
		MUID = mUID;
		CUID = cUID;
		this.callDuration = callDuration;
		this.telephoneCharge = telephoneCharge;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMUID() {
		return MUID;
	}
	public void setMUID(String mUID) {
		MUID = mUID;
	}
	public String getCUID() {
		return CUID;
	}
	public void setCUID(String cUID) {
		CUID = cUID;
	}
	public Integer getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(Integer callDuration) {
		this.callDuration = callDuration;
	}
	public Double getTelephoneCharge() {
		return telephoneCharge;
	}
	public void setTelephoneCharge(Double telephoneCharge) {
		this.telephoneCharge = telephoneCharge;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", MUID=" + MUID + ", CUID=" + CUID + ", callDuration=" + callDuration
				+ ", telephoneCharge=" + telephoneCharge + "]";
	}
	
	

}
