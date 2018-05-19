package purpose;

import java.util.LinkedList;

public interface PurposeInterface 
{
	int addpurpose(String purpose_name,String purpose_code);
	LinkedList generatePurposeList(String purpose_id,String flag);
	int purposeModification(int purpose_id,String purpose_name,String purpose_code);
	int purposeDeletion(int purpose_id);
	LinkedList megaHuntPurpose(String purpose_name,String purpose_code);

}
