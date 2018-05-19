package classes.exception;

public class MyCustomExceptionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new MyExceptionImpl("catch");
		} catch (MyCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Got it");
		}

	}

}
