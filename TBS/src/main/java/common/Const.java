package common;

//枚举
public class Const {
	//客户类型优惠
	public static enum Sale{
		PUBLIC_CUSTOMER("公客",1.00),SPECIALITY("专客",0.98),BUSINESS_CUSTOMER("商客",0.95),BIG_CUSTOMER("大客",0.90);
		private String key;
		private Double value;

		private Sale(String key, Double value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	}
	
	public static double sale(String CUSTOMER_TYPE){
		if(CUSTOMER_TYPE==Sale.PUBLIC_CUSTOMER.getKey()){
			return Sale.PUBLIC_CUSTOMER.getValue();
		}else if(CUSTOMER_TYPE==Sale.SPECIALITY.getKey()){
			return Sale.SPECIALITY.getValue();
		}else if(CUSTOMER_TYPE==Sale.BUSINESS_CUSTOMER.getKey()){
			return Sale.BUSINESS_CUSTOMER.getValue();
		}else{
			return Sale.BIG_CUSTOMER.getValue();
		}
	}
	
	//供应商结算费率
	public static enum TelephoneRate{
		
		CTCC("电信",0.16),CMCC("移动",0.12),CUCC("联通",0.11),CRC("铁通",0.10);
		
		private String key;
		private Double value;
		private TelephoneRate(String key, Double value) {
			this.key = key;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Double getValue() {
			return value;
		}
		public void setValue(Double value) {
			this.value = value;
		}
	}
	
	public static double telephoneRate(String SUPPLIER){
		if(SUPPLIER==TelephoneRate.CMCC.getKey()){
			return TelephoneRate.CMCC.getValue();
		}else if(SUPPLIER==TelephoneRate.CRC.getKey()){
			return TelephoneRate.CRC.getValue();
		}else if(SUPPLIER==TelephoneRate.CTCC.getKey()){
			return TelephoneRate.CTCC.getValue();
		}else{
			return TelephoneRate.CUCC.getValue();
		}
	}
	
}
