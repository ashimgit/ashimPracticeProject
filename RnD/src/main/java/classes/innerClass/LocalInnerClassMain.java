package classes.innerClass;

class LocalInnerClassTest{
	int i=10;
	void f1(){
		class Inner1{
			void in_m1(){System.out.println("This is from inner method and i= "+i);}
		}
		Inner1 obj=new Inner1();
		obj.in_m1();
	}
}

public class LocalInnerClassMain {

	public static void main(String[] args) {
		new LocalInnerClassTest().f1();
	}
	
}
