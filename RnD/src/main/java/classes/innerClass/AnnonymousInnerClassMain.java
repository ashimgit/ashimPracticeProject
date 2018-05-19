package classes.innerClass;

abstract class AnnonymousInnerTest {
	abstract void f1();
}
interface I1{
	void interF1();
}
class AnnonymousImplemented {
	void accessMethod() {
		// void f1(){System.out.println("This is f1 from
		// AnnonymousImplemented");}
		AnnonymousInnerTest objAnonymInner = new AnnonymousInnerTest() {
			void f1() {
				System.out.println("This is from AnnonymousImplemented->accessMethod()");
			}
		};
		objAnonymInner.f1();

	}

}
class InterfaceImplemented{
	void implementInterF1(){
		I1 obj=new I1(){public void interF1() {
			System.out.println("This is an Interface implemented method");
			
		}};
		obj.interF1();
	}
}

public class AnnonymousInnerClassMain {
	public static void main(String[] args) {
		new AnnonymousImplemented().accessMethod();
		System.out.println("*******************************");
		new InterfaceImplemented().implementInterF1();
	}
}
