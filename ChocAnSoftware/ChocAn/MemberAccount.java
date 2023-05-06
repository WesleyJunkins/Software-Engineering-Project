package ChocAn;

import java.util.Vector;

public class MemberAccount extends Account 
{
	int status;
	Vector<ServiceLog> servicesAccessed;
	
	public MemberAccount (String fn, String ln, String address, String ci, String st, int zip, String phone)
	{
		super(fn, ln, "member", address, ci, st, zip, phone);
		
		servicesAccessed = new Vector<ServiceLog>();
		status = 1;
	}
	
	public void weeklyReset()
	{
		for(int i = 0; i < servicesAccessed.size(); i++)
		{
			servicesAccessed.remove(i);
		}
	}
	
	public Vector<ServiceLog> getServicesAccessed()
	{
		return servicesAccessed;
	}
	
	public void updateStatus(int s)
	{
		status = s;
	}
	
	public void addService(ServiceLog service) 
	{
		servicesAccessed.add(service);
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public String getProviderName()
	{
		return "";
	}
	
	public String getProviderNumber() // Might need to return a String instead
	{
		return "";
	}
	
	public int getNumConsultations()
	{
		return servicesAccessed.size();
	}
}