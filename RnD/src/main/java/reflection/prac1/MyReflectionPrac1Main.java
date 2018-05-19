package reflection.prac1;

import java.lang.reflect.Method;

public class MyReflectionPrac1Main {
	public static void main(String[] args) {
		try {
			//ClassLoader myLoader=MyReflectionPrac1Main.class.getClassLoader();
			//myTestClass=myLoader.loadClass("MyTestClass");
			
			//myTestClass=Class.forName("String");
			Class myTestClass=null;
			myTestClass=Class.forName("reflection.prac1.MyTestClass");
			
			System.out.println(myTestClass.getName());
			Method[] myMethods=myTestClass.getDeclaredMethods();
			for(Method m:myMethods){
				System.out.println("Method is ="+m);
				if(m.getName().equals("show"))
				m.invoke(myTestClass.newInstance(),"hi");
			}
			
			System.out.println("Its OK still");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
