package category;
import java.util.*;

public interface CategoryInterface {
	int addCategory(String category_name);
	LinkedList generateCategoryList(String category_id,String flag);
	int categoryModification(int category_id,String category_name);
	int categoryDeletion(int category_id);
	LinkedList megaHuntCategory(String category_name);

}
