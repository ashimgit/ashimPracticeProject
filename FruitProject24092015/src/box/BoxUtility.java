package box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoxUtility {

	Connection con=db.connection.DBConnection.getConnection();
	PreparedStatement pst=null;
	ResultSet rs=null;
	public ArrayList cidValidate(String cid){	//validate a customer present of not
		ArrayList flag=null;
		
		String query="select cid,cname from customer where cid='"+cid+"'";
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			if(rs.next()){
				flag.add("Valid Customer : "+rs.getString(2));
				flag.add(noOfBox(cid));
				
			}
			else{
				flag.add("invalid Customer");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	int noOfBox(String cid){	//calculate the no of box remained
		int flag=0;
		String query="select cid,no_of_boxs from customer_vs_boxs where cid=''"+cid+"";
		try {
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				flag=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally{
			try {
				con.close();
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return flag;
	}
}
