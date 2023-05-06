//By Wesley Junkins
//Javadocs are complete
package ChocAn;

/**
 * 
 * @author wesjunkins
 *@version 4/27/2023
 */
public class ManagerController {
	DataCenter dc;
	
	/**
	 * Constructor
	 * @param dataCenter for storing data
	 */
	public ManagerController(DataCenter dataCenter) {
		dc = dataCenter;
	}
	
	/**
	 * Getting individual reports
	 * @param type for knowing what type of account to look for
	 * @param id for knowing the exact account to print a report for
	 */
	public void requestIndividualReports(String type, int id) {
		//System.out.println("type = "+type+" id = "+id);
		if(type.equals("manager"))
		{
			
			//mr.generateReport();
			//ManagerReport mr = new ManagerReport();
			Account manager = null;
			for (Account m : dc.getManagerList()) {
				if (m.getID() == id)
					manager = m;
			}
			if (manager != null)
			{
				ManagerReport mr = new ManagerReport(manager, dc);
				mr.generateReport();
			}
		}else
		if(type.equals("provider"))
		{
			System.out.println("Inside the provider section of manager print report function");
			//pr.generateReport();
			//ProviderReport pr = new ProviderReport();
			ProviderAccount provider = null;
			for (ProviderAccount p : dc.getProviderList()) {
				if (p.getID() == id)
					provider = p;
			}
			if (provider != null) 
			{
				ProviderReport pr = new ProviderReport(provider); //Where do we get the provider account to use? FIXME
				pr.generateReport(); //Removed pr.generateReport(provider);
			}
				
		}else
		if(type.equals("member"))
		{
			//memr.generateReport();
			//MemberReport memr = new MemberReport();
			MemberAccount member = null;
			for (MemberAccount m : dc.getMemberList()) {
				if (m.getID() == id)
					member = m;
			}
			if (member != null)
			{
				MemberReport memr = new MemberReport(member); //Where do we get the member account to use? FIXME
				memr.generateReport(); //Removed memr.generateReport(member);
			}
		}
		return;
	}
	
	/**
	 * Request all reports
	 * @param type for knowing which type of report to request all of
	 */
	public void requestAllReports(String type) {
		System.out.println("Manager Reports:\n");
		ManagerReport mr = new ManagerReport(null, dc); //Where do we get the accounts for this? FIXME
		mr.generateReport();
		System.out.println("Provider Reports:\n");
		ProviderReport pr = new ProviderReport(null); //This too
		pr.generateReport();
		System.out.println("Member Reports:\n");
		MemberReport memr = new MemberReport(null); //This too
		memr.generateReport();
	}
}