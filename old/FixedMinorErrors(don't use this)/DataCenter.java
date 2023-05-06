package ChocAn;

import java.util.Vector;

public class DataCenter
{
	private Vector<Service> providerDirectory;
	private Vector<MemberAccount> memberList;
	private Vector<ProviderAccount> providerList;
	private Vector<Account> managerList;
	private Vector<Account> operatorList;
	private Vector<ServiceLog> serviceLogList;
	
	public DataCenter()
	{
		providerDirectory = new Vector<Service>();
		memberList = new Vector<MemberAccount>();
		providerList = new Vector<ProviderAccount>();
		managerList = new Vector<Account>();
		operatorList = new Vector<Account>();
		serviceLogList = new Vector<ServiceLog>();
	}
	
	public Vector<Service> getProviderDirectory()
	{
		return providerDirectory;
	}
	
	public Vector<MemberAccount> getMemberList()
	{
		return memberList;
	}
	
	public Vector<ProviderAccount> getProviderList()
	{
		return providerList;
	}
	
	public Vector<Account> getManagerList()
	{
		return managerList;
	}
	
	public Vector<Account> getOperatorList()
	{
		return operatorList;
	}
	
	public Vector<ServiceLog> getServiceLog()
	{
		return serviceLogList;
	}
	
	public void addServiceLog(ServiceLog log)
	{
		serviceLogList.add(log);
	}
	
	public void addMember(MemberAccount m)
	{
		memberList.add(m);
	}
	
	public void addProvider(ProviderAccount p)
	{
		providerList.add(p);
	}
	
	public void addService(Service s)
	{
		providerDirectory.add(s);
	}
	
	public void addOperator(Account o)
	{
		operatorList.add(o);
	}
	
	public void addManager(Account m)
	{
		managerList.add(m);
	}
}