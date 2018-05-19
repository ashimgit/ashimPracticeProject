package approval;
import java.util.*;

public interface ApprovalInterface 
{
	//LinkedList fetchSMEJoiningList();
	int SMEApproval(int sme_id);
	int approvalAllSME();
	LinkedList execute();
	LinkedList fetchSMEVisitList();
	int SMEVisitApproval(int sme_id,String user_id);
	LinkedList getsmedetails(int sme_id);
}
