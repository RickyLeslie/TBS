package infomodule.pojo;

import java.io.Serializable;

public class StaffLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; //日志ID  使用自增长
	private String staff_id; //员工ID
	private String log_type; //操作类型
	private String log_time; //操作时间
	private String log_object; //操作对象
	private String log_text; //操作备注
	public StaffLog() {
		super();
	}
	public StaffLog( String staff_id, String log_type, String log_time, String log_object, String log_text) {
		super();
		this.staff_id = staff_id;
		this.log_type = log_type;
		this.log_time = log_time;
		this.log_object = log_object;
		this.log_text = log_text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public String getLog_object() {
		return log_object;
	}
	public void setLog_object(String log_object) {
		this.log_object = log_object;
	}
	public String getLog_text() {
		return log_text;
	}
	public void setLog_text(String log_text) {
		this.log_text = log_text;
	}
	@Override
	public String toString() {
		return "StaffLog [id=" + id + ", staff_id=" + staff_id + ", log_type=" + log_type + ", log_time=" + log_time
				+ ", log_object=" + log_object + ", log_text=" + log_text + "]";
	}
	
	
}
