package pop1;

public class TowerInfoBean 
{
	private int serviceprovider_id;
	private String serviceprovider_name;
	
	TowerInfoBean(int serviceprovider_id,String serviceprovider_name)
	
	{
		
		this.serviceprovider_id = serviceprovider_id;
		this.serviceprovider_name = serviceprovider_name;
				
	}
	
	public String toString()
	{
		return "<tr><td>"+serviceprovider_id+"</td><td>"+serviceprovider_name+"</td></tr>";
	}
}
