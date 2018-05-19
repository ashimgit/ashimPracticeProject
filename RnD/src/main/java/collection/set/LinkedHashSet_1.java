package collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSet_1 {

	public static void main(String[] args) {
		LinkedHashSet h=new LinkedHashSet();
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
		
		LinkedHashSet h1=new LinkedHashSet(al);
		System.out.println("h1= " +h1);
		
		//System.out.println(h.size());
		
		System.out.println(new DummyClass().hashCode()+"   ***  "+new DummyClass().hashCode());
	}

}
