package serviceprovider;

import java.util.LinkedList;

public interface ServiceProviderInterface 
{
	int addServiceProvider(int Category_id,String ServiceProvider_name);
	LinkedList generateServiceProviderList(String state_id,String state_name);
	LinkedList megaHuntServiceProvider(String serviceprovider_name,int category_id);
	int serviceProviderModification(int serviceprovider_id,String serviceprovider_name,int category_id);
	int serviceproviderDeletion(int serviceprovider_id);
	LinkedList execute();
}
