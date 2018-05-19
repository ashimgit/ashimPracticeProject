package exception;

import java.util.ArrayList;
import java.util.List;

class ResourceDeclrWthnTry{
	public List<String> getList(){
		int i1;
		try{
			List<String> l1=new ArrayList<String>();
			l1.add("asd");
		}catch(Exception e){
			
		}
		return l1;
	}
}

public class MyExceptionMain {

}
