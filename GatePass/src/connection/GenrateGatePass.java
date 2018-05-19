package connection;
import java.util.*;
import java.text.*;

public class GenrateGatePass 
{
	public String GetscheduledGatePass()
	{
/* -------------------------- Generating GatePass Number Starts -------------------------------------------*/
	int seqcnt=0;
	java.util.Random rnd=new java.util.Random();
	for(int i=1;i<=100000;i++)
	{
		seqcnt=rnd.nextInt(100000);
	}
    System.out.println("retrive_count"+seqcnt);
	java.util.Date date = new java.util.Date();
	SimpleDateFormat sdf;
	sdf = new SimpleDateFormat("yyMMdd");//dd:MM:yyyy
	String dt1=sdf.format(date);
	java.util.Date currentdate = new java.util.Date();
	SimpleDateFormat currsdf;
	currsdf = new SimpleDateFormat("yyMMdd");//dd:MM:yyyy
	String currdt1=sdf.format(date);
	
	
	int cdate=date.getDate();//.getHours()*1000*60*60;
	String currdate=""+cdate;
		if(cdate<10)
		{
			currdate="0"+cdate;
		}
		

    int cmonth=(date.getMonth()+1);//.getMinutes()*1000*60;
    String currmonth=""+cmonth; 
    	if(cmonth<10)
    	{
    		currmonth="0"+cmonth;
    	}
    	
    int curryear=((date.getYear()+1900)%100);//.getSeconds()*1000;
    String currdt=""+curryear+currmonth+currdate+1;
    //out.println("in milisec---"+hour+" "+(mint+1)+" "+(secnd+1900)%100);
	int hr=date.getHours();//*1000*60*60;
	String hour=""+hr;
		if(hr<10)
		{
			hour="0"+hr;
		}
	int mint=date.getMinutes();//*1000*60;
    
    String minit=""+mint;
    if(mint<10)
    	{
    	 minit="0"+mint;
    	}
    int secnd=date.getSeconds();//*1000;
    String second=""+secnd;
    if(secnd<10)
	{
    	second="0"+secnd;
	}
    long milsc=date.getTime();
	String currtm=""+hour+minit+second+(milsc%1000);
	//String currtm=""+date.getHours()+date.getMinutes()+date.getSeconds()+milsc%1000;//""+currentTime;
	System.out.println("system time:--------------"+"     "+currdt+"  -- "+currtm);
	String gpass=Long.toHexString(Long.parseLong((currdt+currtm)));// Integer.toHexString(Integer.parseInt(currdt)).toUpperCase();
	//String gpass2=Integer.toHexString(currentTime);
	
	
/* -------------------------- Generating GatePass Number Ends -------------------------------------------*/
	return gpass;
	}
/*Gatepass : <gatepass number> for  <tower id> to <first name> of <company name> on <date> at <time> due to <purpose name>
Gatepass :5038fd2b60aa2 for  IN-1257993 to Subhajit of Rtizen on 29.11.2014 at 13.38 due to Repairing	
*/	
	public String scheduledtextmsg(String GatePass,String Indus_tower_code,String Schedule_date,String Scheduled_time)
	{
		String TextMsg= "";
		TextMsg="Gatepass :"+GatePass+" "+"for  IN-"+Indus_tower_code+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time;
		System.out.println("MSG"+TextMsg);
		
		return TextMsg;
	}
	
	public String scheduledtextmsg(String GatePass,String Indus_tower_code,String Schedule_date,String Scheduled_time,String purpose_name1,String sme_name1,String serviceprovider_name1)
	{
		String TextMsg= "";
		TextMsg="Gatepass :"+GatePass+" "+"for  IN-"+Indus_tower_code+" "+"to"+" "+sme_name1+" "+"of"+" "+serviceprovider_name1+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time+" "+"due to"+" "+purpose_name1;
		System.out.println("MSG"+TextMsg);
		
		return TextMsg;
	}
	public String scheduledtextmsg1(String GatePass,String Indus_tower_code,String Schedule_date,String Scheduled_time,String purpose_name1,String sme_name1,String serviceprovider_name1,String gatekeeper_mobile,String mobile_no,String gatekeeper_name)
	{
		String TextMsg= "";
		//TextMsg="Gatepass :"+GatePass+" "+"for  IN-"+Indus_tower_code+" "+"to"+" "+sme_name1+" "+"of"+" "+serviceprovider_name1+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time+" "+"due to"+" "+purpose_name1;
		TextMsg="Gatepass :"+GatePass+" "+"for IN-"+Indus_tower_code+" with "+gatekeeper_name+"-"+gatekeeper_mobile+" to"+" "+sme_name1+"-"+mobile_no+" of"+" "+serviceprovider_name1+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time+" "+"due to"+" "+purpose_name1;
		//TextMsg="Gatepass :"+GatePass+" "+"for IN-"+Indus_tower_code+" with "+gatekeeper_name+"-"+gatekeeper_mobile+" to"+" "+sme_name1+"-"+mobile_no+" of"+" "+serviceprovider_name1+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time;
		System.out.println("MSG"+TextMsg);
		
		return TextMsg;
	}
	public String scheduledtextmsg2(String GatePass,String Indus_tower_code,String Schedule_date,String Scheduled_time,String sme_name1,String serviceprovider_name1,String gatekeeper_mobile,String mobile_no,String gatekeeper_name)
	{
		String TextMsg= "";
		TextMsg="Gatepass :"+GatePass+" "+"for IN-"+Indus_tower_code+" with "+gatekeeper_name+"-"+gatekeeper_mobile+" to"+" "+sme_name1+"-"+mobile_no+" of"+" "+serviceprovider_name1+" "+"on"+" "+Schedule_date+" "+"at"+" "+Scheduled_time;
		System.out.println("MSG"+TextMsg);
		
		return TextMsg;
	}
	public String GetunscheduledGatePass()
	{
/* -------------------------- Generating GatePass Number Starts -------------------------------------------*/
	
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
	    String dt1 = sdf.format(date);
	    int cdate = date.getDate();
	    String currdate = String.valueOf(cdate);
	    if (cdate < 10)
	    {
	       currdate = "0" + cdate;
	    }
	    int cmonth = date.getMonth() + 1;
	    String currmonth = String.valueOf(cmonth);
	    if (cmonth < 10)
	    {
	       currmonth = "0" + cmonth;
	    }
	    int curryear = (date.getYear() + 1900) % 100;
	    String currdt = curryear + currmonth + currdate + 2;
	    int hr = date.getHours();
	    String hour = String.valueOf(hr);
	    if (hr < 10)
	    {
	       hour = "0" + hr;
	    }
	    int mint = date.getMinutes();
	    String minit = String.valueOf(mint);
	    if (mint < 10)
	    {
	       minit = "0" + mint;
	    }
	    int secnd = date.getSeconds();
	    String second = String.valueOf(secnd);
	    if (secnd < 10)
	    {
	       second = "0" + secnd;
	    }
	    long milsc = date.getTime();
	    String currtm = hour + minit + second + milsc % 1000L;
	
	    System.out.println("system time:--------------     " + currdt + "  -- " + currtm);
	    String gpass = Long.toHexString(Long.parseLong(currdt + currtm));
	    /* -------------------------- Generating GatePass Number Ends -------------------------------------------*/
		return gpass;
	} 
	
	public String unscheduledtextmsg(String GatePass,String Indus_tower_code,String Schedule_date,String Scheduled_time,String name,String company_name)
	{
		String TextMsg= "";
		TextMsg = "Gatepass:" + GatePass + "  for " + "IN-" + Indus_tower_code + " " + "on" + " " + Schedule_date + " " + "at" + " " + Scheduled_time + " for " + name + " of " + company_name;
	    System.out.println("MSG" + TextMsg);
		
		return TextMsg;
	}
	public String scheduledmsg(String gatePass, String indus_tower_id,String sme_name1, String mobile_no, String serviceprovider_name1, String sch_dt, String sch_tm, String purpose_name1, String gatekeeper_name, String gatekeeper_mobile)
	{
		String TextMsg= "";
		TextMsg = "Gatepass:" + gatePass + " for " + "IN-" + indus_tower_id + " issued to " + sme_name1 + " - " + mobile_no + " of " + serviceprovider_name1 + " on " + sch_dt + " at " + sch_tm + " for " + purpose_name1 + ". Technician - " + gatekeeper_name + "-" + gatekeeper_mobile ;
		return TextMsg;
	}
	
//Gatepass : 89165b4ddb37 for IN-1055555 issued to Subhajit-8900244895 of P&G Co on 29.07.2015 at 14:11 for Checking.  Technician - Subhajit Kar-8900244895


}
