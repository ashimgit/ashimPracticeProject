package classes.prac.interface1;

final class A{
	private int i;
	
	private A(){}
	A(int i){this.i=i;}
	public A modifyA(int i){
		if(this.i==i)
		return this;
		else
			return new A(i);
	}
}

public class Interface1Main implements Interface1{

	public static void main(String[] args) {
		

	}
	public int f1(int i){return 0;}
	public String f2(String s){return "Hi";}
}
