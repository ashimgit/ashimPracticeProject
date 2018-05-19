package connection;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Arrays;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class SMSEngine 
{
	private static String SMS_SERVICE_URL = "http://api.myvaluefirst.com/psms/servlet/psms.Eservice2";
	private static String ADDRESS_TAG = "<ADDRESS FROM=\"{0}\" TO=\"{1}\" SEQ=\"{2}\" />";

	// Appended text <!DOCTYPE...........
	private static String DATA_TAG = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE MESSAGE SYSTEM \"http://127.0.0.1/psms/dtd/message.dtd\" ><MESSAGE><USER USERNAME=\"{0}\" PASSWORD=\"{1}\"/><SMS UDH=\"0\" CODING=\"1\" TEXT=\"{2}\" PROPERTY=\"\" ID=\"1\">{3}</SMS></MESSAGE>";
	
	private int message = 0;
	
	public void sendSMS(final String from, final List toList, final String text) 
	{
		
		Thread t = new Thread(new Runnable() 
		{
			public void run()
			{
				try 
				{
					// System.out.println("sendSMS");
					HttpClient client = new HttpClient();
					PostMethod method = new PostMethod(SMS_SERVICE_URL);
					String dataParameter = getDataParameter(from, toList, text);
					method.addParameter("data", dataParameter);
					method.addParameter("action", "send");
					client.executeMethod(method);
					System.out.println("sendSMS");
					System.out.println(method.getResponseBodyAsString());
					message = 007;
				} 
				catch (HttpException e) 
				{
					message = 1;
					System.out.println("Error in sending SMS.(HTTP Exception)"+ e.toString());
				} 
				catch (IOException e) 
				{
					message = 2;
					System.out.println("Error in sending SMS.(IO Exception)"+ e.toString());
				}
				
			}
		});
		t.start();
		//return message;
	}

	private String getDataParameter(String from, List toList, String text) {

		final String userName = "smsindusrob";// "smsindusrob";
		final String password = "smsindusrob423324";// "rtizen2007";

		StringBuffer addressTags = new StringBuffer();
		for (int i = 0; i < toList.size(); i++) 
		{
			String address = (String) toList.get(i);
			addressTags.append(MessageFormat.format(ADDRESS_TAG, new Object[] 
			{
					from, address, new Integer(i + 1) 
			}));
		}
		return MessageFormat.format(DATA_TAG, new Object[] { userName,
				password, text, addressTags });
	}

	public static String encodeHTML(String s) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 32 && c <= 46) || (c >= 58 && c <= 64)
					|| (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
				out.append("&#" + (int) c + ";");
				// out.append((int)c);
			} else {
				out.append(c);
				// System.out.println(out.toString());
			}
		}
		return out.toString();
	}

	/*
	 * public static void main(String args[]){ SMSEngine vd = new SMSEngine();
	 * Object[] array = new Object[]{"9674219406"}; java.util.List toList =
	 * Arrays.asList(array); vd.sendSMS("9674219406", toList,
	 * encodeHTML("hello world")); }
	 */
}