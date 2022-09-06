package bean;

import java.sql.Timestamp;

public class Data {

	private int id;
	private String data;
	private Timestamp createDate;
	private Timestamp updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
		
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
		
	}
}
