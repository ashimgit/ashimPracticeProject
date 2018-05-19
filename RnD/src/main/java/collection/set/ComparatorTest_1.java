package collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class ComparatorTest_1 {

	public static void main(String[] args) {
		TreeSet h=new TreeSet(new DummyClass());
		ArrayList al=new ArrayList();
		h.add(50);
		h.add(25);
		h.add(10);
		//h.add(null);
		h.add(11);
		//System.out.println(h.add("B"));
		System.out.println("h= "+h);
		/*
		al.add("x1");
		al.add("y1");
		al.add("x1");
		al.add("y1");
		System.out.println("al= "+al);
		*/
		
		HashSet h1=new HashSet(al);
		System.out.println("h1= " +h1);
		
		//System.out.println(h.size());
		
		System.out.println(new DummyClass().hashCode()+"   ***  "+new DummyClass().hashCode());
	}

}
