package sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public interface SMSInterface 
{
	int addScheduleSMS(String indus_tower_id,String mobile_no,String date,int purpose,String gatepass_no,String sms_generated,String interface_type,String gatekeeper_mobile,String clustermanager_mobile, String message_text);
	LinkedList execute();
	LinkedList check_tower_sp(String indus_tower_id);
	int getserviceprovider_id(String mobile_no);
	int addUnScheduleSMS(String indus_tower_id, String mobile_no,String datepicker, int purpose_id, String gatepass_no,String sms_generated, String interface_type, String name,String company_name, String gatekeeper_mobile, String clustermanager_mobile, String message_text);
	LinkedList check_gatepass_no(String gatepass_no,int VitorType);
	int addcancelSMS(int scheduled_id,int VitorType);
	int addconfirmationSMS(int scheduled_id,int VitorType);
	LinkedList getsme_details(String mobile_no);
	String getpurpose_name(int purpose_id);
	LinkedList purpose(String purpose_code);
	int requestcheck(String indus_tower_id,String mobile_no,String date);
	ArrayList tower_supervisor(String indus_tower_id);
}
