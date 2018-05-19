package tower;

import java.util.LinkedList;

public interface TowerInterface {
	int addTower(String site_name,String address,String tower_type,int district_id,String height,String latitude,String longitude,String indus_tower_code,String gatekeeper_mobile,String clustermanager_mobile);
	LinkedList generateTowerList(String tower_id,String tower_name);
	String towerModification(int tower_id,String indus_tower_code,String site_name,String address,String tower_type,String height,String latitude,String longitude,int district_id,String gatekeeper_mobile,String clustermanager_mobile,int serviceprovider_id);
	int towerDeletion(int tower_id);
	String unassignTower(int tower_id,String flag);
	int towerModification(int tower_id, String indus_tower_code,
			String site_name, String address, String tower_type, String height,
			String latitude, String longitude, int district_id,
			String gatekeeper_mobile, String clustermanager_mobile);
	int towerModification(String indus_tower_code, String site_name,
			String address, String tower_type, String height, String latitude,
			String longitude, int district_id, String gatekeeper_mobile,
			String clustermanager_mobile);
	LinkedList checkTowerList(String value, String string);
}
