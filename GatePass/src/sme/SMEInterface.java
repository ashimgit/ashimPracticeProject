package sme;

import java.util.LinkedList;

public interface SMEInterface
{
	int addSME(String mobile,String SME_name,int serviceprovider_id,int smetype_id);
	LinkedList generateSMEList(String sme_id,String sme_name);
	LinkedList generateSMEListHaddi(String sme_id,String sme_name,int serviceprovider_id,int smetype_id);

	int SMEModification(int sme_id,String mobile,String sme_name,int serviceprovider_id,int smetype_id);
	int smeDeletion(int sme_id);
	int checkSMEMobile(String mobile);

	LinkedList execute();

}
