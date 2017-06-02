package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class EmployeeBean {
	private String empCode;
	private String lName;
	private String fName;
	private String lRubyName;
	private String fRubyName;
	private String sex;
	private Date BirthDay;
	private String sectionName;
	private Date empDate;
	private String licenseName;
	private Timestamp updateDate;

	public EmployeeBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlRubyName() {
		return lRubyName;
	}

	public void setlRubyName(String lRubyName) {
		this.lRubyName = lRubyName;
	}

	public String getfRubyName() {
		return fRubyName;
	}

	public void setfRubyName(String fRubyName) {
		this.fRubyName = fRubyName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public String getLicenseName() {
		return licenseName;
	}

	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
