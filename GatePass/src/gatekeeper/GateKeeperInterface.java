package gatekeeper;

import java.util.LinkedList;

public interface GateKeeperInterface 
{
	int addGateKeeper(String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id);
	int updateTower(String mobile_no, String indus_tower_id);
	LinkedList generateGateKeeperList(String gatekeeper_id,String gatekeeper_name);
	LinkedList megeHuntGateKeeper(int gatekeeper_id,String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id);
	int gateKeeperDeletion(int gatekeeper_id);
	int gateKeeperModification(int gatekeeper_id,String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id);
}
