package login;

import java.util.*;

interface LoginInterface 
{
	LinkedList logincheck(String username, String password);

	int insert_log_details(int userid, String ip);

	ArrayList getDynamicMenu(String object);

	LinkedList message_send_tillnow();

	
}