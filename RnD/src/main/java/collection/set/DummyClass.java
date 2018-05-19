package collection.set;

import java.util.Comparator;

public class DummyClass implements Comparator{

	public int compare(Object o1, Object o2) {
		Integer i1=(Integer) o1;
		Integer i2=(Integer) o2;
		
		return i1.compareTo(i2);
	}

	
}
