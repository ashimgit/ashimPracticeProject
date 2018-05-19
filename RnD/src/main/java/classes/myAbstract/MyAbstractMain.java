package classes.myAbstract;

abstract class A{
	int i=10;
	A(){
		System.out.println("A");
	}
	public void show(){
		System.out.println("Hi abstract");
	}
	public abstract void go();
}
class B extends A{

	B(){
		this("from B()");
		System.out.println("B");
	}
	B(String s){System.out.println("Parameterised B(...) - > "+s);}
	@Override
	public void go() {
		
		System.out.println("Hi Non Abstract GO");
	}
	
}
public class MyAbstractMain {

	public static void main(String[] args) {
		new B().go();

	}

}
