package classes.exception;

public class MyCustomException extends Throwable{
	public MyCustomException(String msg){
		super(msg);
	}
}
class MyExceptionImpl {

	public MyExceptionImpl(String msg) throws MyCustomException{
		if(msg.equals("catch"))
			throw new MyCustomException("From My Exception :: "+msg);
		else
			System.out.println("Not catched : "+msg);
	}
	
}

