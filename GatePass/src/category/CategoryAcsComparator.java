package category;

import java.util.Comparator;

public class CategoryAcsComparator implements Comparator<CategoryAction>{

	@Override
	public int compare(CategoryAction o1,CategoryAction o2) {
		return o1.getCategory_name().compareTo(o2.getCategory_name());
	}
	

}
