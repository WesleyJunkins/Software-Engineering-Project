//By Wesley Junkins
package ChocAn;

public class ManagerController {
	DataCenter dc;
	public ManagerController(DataCenter dataCenter) {
		dc = dataCenter;
	}
	
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