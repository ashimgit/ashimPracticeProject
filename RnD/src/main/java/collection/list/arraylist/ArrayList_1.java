package collection.list.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayList_1 {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		ArrayList al_1=new ArrayList();
		
		al_1.add("a1");
		al_1.add("a2");
		al_1.add("a3");
		
		al.add("ashim");
		al.add("avijit");
		al.add("arko");
		al.add("bijoy");
		al.add("debu");
		
		al.addAll(al_1);
		System.out.println("al=" +al);
		
		ListIterator litr=al.listIterator();
		System.out.println("Using List Iterator : ");
		while(litr.hasNext()){
			System.out.println(litr.next());
			
		}

		
	}

}
