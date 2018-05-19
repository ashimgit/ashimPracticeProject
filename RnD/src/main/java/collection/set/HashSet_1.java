package collection.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSet_1 {

	public static void main(String[] args) {
		HashSet h=new HashSet();
		ArrayList al=new ArrayList();
		h.add("A");
		h.add("B");
		h.add("C");
		h.add(null);
		h.add(10);
		System.out.println(h.add("B"));
		System.out.println("h= "+h);
		
		al.add("x1");
		al.add("y1");
		al.add("x1");
		al.add("y1");
		System.out.println("al= "+al);
		
		HashSet h1=new HashSet(al);
		System.out.println("h1= " +h1);
		
		//System.out.println(h.size());
		
		System.out.println(new DummyClass().hashCode()+"   ***  "+new DummyClass().hashCode());
	}

}
