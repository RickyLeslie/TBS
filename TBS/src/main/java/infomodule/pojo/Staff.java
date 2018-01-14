package infomodule.pojo;

import java.io.Serializable;

public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id; //员工ID
	private String staffName; //员工姓名
	private String password; //密码
	public Staff() {
		super();
	}
	public Staff(String id, String staffName, String password) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", password=" + password + "]";
	}
	
	

}
