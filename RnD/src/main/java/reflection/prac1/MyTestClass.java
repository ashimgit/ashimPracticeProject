package reflection.prac1;

public class MyTestClass {
	
	public int i;
	public String ename;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	void show(String s){
		System.out.println("yes .........   "+s);
	}

}
