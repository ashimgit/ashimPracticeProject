package report;

import java.util.LinkedList;

public interface ReportInterface 
{
	LinkedList fetchSMEJoiningList(int serviceprovider_id);
	LinkedList fetchSMEVisitApprovalList();
	LinkedList fetchSMSSendReport(int serviceprovider_id);
	LinkedList ValidatingGatePass(String gatePass);
	LinkedList megaHuntSendSMS(String indus_tower_id,String sme_mobile,String interface_type,String sme_schedule_type,String sme_name,String company_name,String from,String to, int serviceprovider_id);

}
