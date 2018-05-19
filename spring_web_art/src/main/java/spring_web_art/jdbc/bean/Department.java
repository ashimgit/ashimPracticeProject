package spring_web_art.jdbc.bean;

public class Department {
	String deptId;
	String deptName;
	String deptNo;
	
	public Department(String deptId,String deptName,String deptNo) {
		this.deptId=deptId;
		this.deptName=deptName;
		this.deptNo=deptNo;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	

}
