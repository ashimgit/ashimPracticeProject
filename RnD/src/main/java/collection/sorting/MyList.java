package collection.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyList {

	public static void main(String[] args) {
		//List ll=new LinkedList(new MyComparator1());
		Set ll=new TreeSet(new MyComparator1());
		ll.add("m");
		ll.add("a");
		ll.add("10");
		ll.add("ashim");
		
		System.out.println(ll);
		
	}

}
