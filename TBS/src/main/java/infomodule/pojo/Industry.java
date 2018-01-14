package infomodule.pojo;

import java.io.Serializable;

public class Industry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String industryName;
	
	public Industry() {
		super();
	}

	public Industry(String id, String industryName) {
		super();
		this.id = id;
		this.industryName = industryName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	@Override
	public String toString() {
		return "Industry [id=" + id + ", industryName=" + industryName + "]";
	}
	
	
	

}
