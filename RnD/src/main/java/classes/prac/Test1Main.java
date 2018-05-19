package classes.prac;

public class Test1Main {
	public static void main(String[] args) {
		Parent obP=new Child();
		
		
		obP.m1(10);
		
		((Child) obP).f1(); 
	}
}
