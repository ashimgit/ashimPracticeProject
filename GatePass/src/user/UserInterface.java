package user;

import java.util.LinkedList;

public interface UserInterface 
{
	int adduser(String mobile_no,String user_name,int usertype_id,String password,int serviceprovider_id,String name);
	LinkedList generateUserList(int userid1,String flag,String usertype_id);
	int userDeletion(int user_id);
	int UserModification(int user_id,String mobile_no,String user_name,String name,String password,int serviceprovider_id,int usertype_id);
	LinkedList execute(int flag);
	LinkedList megaHuntUser(String name,String mobile_no,int serviceprovider_id,int usertype_id);

}
