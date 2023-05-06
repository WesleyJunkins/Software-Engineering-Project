//Nicholas Seidl
package ChocAn;

import java.util.Vector;
/**
 * The DataCenter class. This class stores the various accounts used by the software. 
 * Additionally, it also stores which services are offered and records of the services that have been provided. 
 * @author Nicholas Seidl
 * 
 */

public class DataCenter
{
	/**
	 * Contains a list of all the services available to members
	 */
	private ProviderDirectory providerDirectory;
	/**
	 * Contains a list of all the member accounts
	 */
	private Vector<MemberAccount> memberList;
	/**
	 * Contains a list of all the provider accounts
	 */
	private Vector<ProviderAccount> providerList;
	/**
	 * Contains a list of all the manager accounts
	 */
	private Vector<Account> managerList;
	/**
	 * Contains a list of all the operator accounts
	 */
	private Vector<Account> operatorList;
	/**
	 * Contains a list of all the service logs that the software has generated
	 */
	private Vector<ServiceLog> serviceLogList;
	
	/**
	 * Default constructor, initializes all fields as empty lists
	 */
	public DataCenter()
	{
		providerDirectory = new ProviderDirectory();
		memberList = new Vector<MemberAccount>();
		providerList = new Vector<ProviderAccount>();
		managerList = new Vector<Account>();
		operatorList = new Vector<Account>();
		serviceLogList = new Vector<ServiceLog>();
	}
	
	/**
	 * Returns the provider directory
	 * @return the provider directory
	 */
	public ProviderDirectory getProviderDirectory()
	{
		return providerDirectory;
	}
	
	/**
	 * Returns the list of member accounts
	 * @return the member list
	 */
	public Vector<MemberAccount> getMemberList()
	{
		return memberList;
	}
	
	/**
	 * Returns the list of provider accounts
	 * @return the provider list
	 */
	public Vector<ProviderAccount> getProviderList()
	{
		return providerList;
	}
	
	/**
	 * Returns the list of manager accounts
	 * @return the manager list
	 */
	public Vector<Account> getManagerList()
	{
		return managerList;
	}
	
	/**
	 * Returns the list of operator accounts
	 * @return the operator list
	 */
	public Vector<Account> getOperatorList()
	{
		return operatorList;
	}
	
	/**
	 * Returns the list of service logs
	 * @return the service log list
	 */
	public Vector<ServiceLog> getServiceLog()
	{
		return serviceLogList;
	}
	
	/**
	 * Adds a new service log to the end of the service log list
	 * @param log the log to be added
	 */
	public void addServiceLog(ServiceLog log)
	{
		serviceLogList.add(log);
	}
	
	/**
	 * Adds a new member account to the end of the member account list
	 * @param m the member account to be added
	 */
	public void addMember(MemberAccount m)
	{
		memberList.add(m);
	}
	
	/**
	 * Adds a new provider account to the end of the provider account list
	 * @param p the provider account to be added
	 */
	public void addProvider(ProviderAccount p)
	{
		providerList.add(p);
	}
	
	/**
	 * Adds a new service to the end of the provider directory
	 * @param s the service to be added
	 */
	public void addService(Service s)
	{
		providerDirectory.add(s);
	}
	
	/**
	 * Adds a new operator account to the end of the operator account list
	 * @param o the operator account to be added
	 */
	public void addOperator(Account o)
	{
		operatorList.add(o);
	}
	
	/**
	 * Adds a new manager account to the end of the manager account list
	 * @param m the manager account to be added
	 */
	public void addManager(Account m)
	{
		managerList.add(m);
	}
}