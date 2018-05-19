package collection.sorting;

import java.util.Comparator;

public class MyComparator1 implements Comparator{

	public int compare(Object o1, Object o2) {
		String s1=(String)o1;
		String s2=(String)o2;
		
		if(s1.compareTo(s2)<1)
			return -1;
		else
			return  1;
		
		
	}

}
