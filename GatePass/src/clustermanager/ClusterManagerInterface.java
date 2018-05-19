package clustermanager;

import java.util.LinkedList;

public interface ClusterManagerInterface 
{
	int addClusterManager(String mobile_no,String clustermanager_name);
	int updateTower(String mobile_no, String indus_tower_id);
	LinkedList generateClusterManagerList(String clustermanager_id,String clustermanager_name);
	int clustermanagerDeletion(int cm_mobile_no);
	int clusterManagerModification(int clustermanager_id,String mobile_no,String clustermanager_name);
}
