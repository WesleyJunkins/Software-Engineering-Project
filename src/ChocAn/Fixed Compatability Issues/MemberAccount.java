/**
 Creates accounts for members, uses Account as superclass
 @author Sam Wood
 @version 4/27/2023
 **/ 


package ChocAn;

import java.util.Vector;

public class MemberAccount extends Account 
{
	int status;
	Vector<ServiceLog> servicesAccessed;
	
	/**
	 * 
	 * Constructor
	 * Passes into Account superclass
	 * @param superclass variables
	 */
	
	public MemberAccount (String fn, String ln, String address, String ci, String st, int zip, String phone)
	{
		super(fn, ln, "member", address, ci, st, zip, phone);
		
		servicesAccessed = new Vector<ServiceLog>();
		status = 1;
	}
	
	/**
	 * weeklyReset clears all services used during the week
	 * 
	 */
	
	public void weeklyReset()
	{
		for(int i = 0; i < servicesAccessed.size(); i++)
		{
			servicesAccessed.remove(i);
		}
	}
	
	/**
	 * Getters for servicesAccessed, provider name/number, # of consultations, status
	 * @return appropriate variable
	 * Setter for status
	 * 
	 */
	
	public Vector<ServiceLog> getServicesAccessed()
	{
		return servicesAccessed;
	}
	
	public void updateStatus(int s)
	{
		status = s;
	}
	
	/**
	 * add a service when checking in
	 * @param service being used
	 */
	
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