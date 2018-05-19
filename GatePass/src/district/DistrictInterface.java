package district;

import java.util.LinkedList;

public interface DistrictInterface 
{
	int adddistrict(int State_id,String District_name);
	LinkedList generateDistrictList(String district_id,String district_name);
	int districtModification(int district_id,String district_name,int state_id);
	int districtDeletion(int district_id);
	LinkedList megaHuntDistrict(String district_name,int state_id);
	LinkedList execute();
	int searchdistrict(String district_name);
	
}
