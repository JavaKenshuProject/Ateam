package entity;

import java.sql.Timestamp;

public class UserBean {
	private String userID;
	private String password;
	private Timestamp updateDate;

	public UserBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
