package entity;

import java.sql.Timestamp;

public class SectionBean {
	private String sectionCode;
	private String sectionName;
	private Timestamp updateDate;

	public SectionBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
