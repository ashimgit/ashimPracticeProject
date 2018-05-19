package collection.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrayListSortMain {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		ArrayList al_1=new ArrayList();
		
		al.add(10);
		al.add(5);
		al.add(50);
		al.add(100);
		al.add(60);
		al.add(20);
		
		//al_1=al;
		System.out.println("al= "+al);
		//System.out.println("al_1= "+al_1);
		
		System.out.println("Size ="+al.size());
		
		for(int i=0;i<=5;i++){
			//al_1.set(i, al.get(i));
			al_1.add(al.get(i));
		}
		
		Collections.sort(al);
		System.out.println("al= "+al);
		System.out.println("al_1= "+al_1);
		
		Collections.sort(al_1, new MyArralistComparator());
		System.out.println("After Customised sorting al_1 = "+al_1);
	
		
	}

}
