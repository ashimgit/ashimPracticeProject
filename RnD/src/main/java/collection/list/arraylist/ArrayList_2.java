package collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList_2 {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();

		if (al != null) {
			System.out.println("Not Null - "+al.size());
			
		} else {
			System.out.println("Al is null");
		}

		al.add("X");
		al.add("A");
		al.add("M");
		al.add("B");
		al.add("a");
		// al.add(null);

		System.out.println("al = " + al);
		Collections.sort(al);
		System.out.println("after sort al = " + al);

		ArrayList<Employee> al1 = new ArrayList();
		Employee e1 = new Employee();
		e1.setEid("1");
		e1.setEname("a");
		e1.setAge(50);
		al1.add(e1);

		Employee e2 = new Employee();
		e2.setEid("2");
		e2.setEname("b");
		e2.setAge(60);
		al1.add(e2);

		System.out.println("al1= " + al1);
		System.out.println("*****************************");
		Iterator itr = al1.iterator();

		// Iterator itr=al.iterator();

		while (itr.hasNext()) {
			System.out.println("after iterator = " + ((Employee) itr.next()).getEid());

			// System.out.println(itr.next().toString());
		}
		System.out.println("*****************************");
		itr = al1.iterator();
		while (itr.hasNext()) {
			Employee e = (Employee) itr.next();
			// String s1=((Employee)itr.next()).getEname();
			// String s1=e.getEid();
			System.out.println("Another itr : " + e.getEid());

		}
		System.out.println("*****************************");
		for (Employee e : al1) {
			System.out.println("For each loop : " + e.getEid());
			
		}
	}

}
