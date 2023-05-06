package chocAn;

public class ManagerController {
	public ManagerController(DataCenter dc) {
		
	}
	
	public void requestIndividualReports(String type, int id) {
		if(type == "manager")
		{
<<<<<<< HEAD
=======
			ManagerReport mr = new ManagerReport(dc);
			//mr.generateReport();
			//ManagerReport mr = new ManagerReport();
>>>>>>> branch 'master' of https://crthompson10@bitbucket.org/azaman2/spring23team17.git
			Account manager = null;
			for (Account m : dc.getManagerList()) {
				if (m.getID() == id)
					manager = m;
			}
			if (manager != null) {
				ManagerReport mr = new ManagerReport(manager);
				mr.generateReport();
			}
		}else
		if(type == "provider")
		{
<<<<<<< HEAD
=======
			ProviderReport pr = new ProviderReport(dc);
			//pr.generateReport();
			//ProviderReport pr = new ProviderReport();
>>>>>>> branch 'master' of https://crthompson10@bitbucket.org/azaman2/spring23team17.git
			ProviderAccount provider = null;
			for (ProviderAccount p : dc.getProviderList()) {
				if (p.getID() == id)
					provider = p;
			}
			if (provider != null) {
				ProviderReport pr = new ProviderReport(provider);
				pr.generateReport();
			}
		}else
		if(type == "member")
		{
<<<<<<< HEAD
			MemberAccount member = null;
=======
			MemberReport memr = new MemberReport(dc);
			//memr.generateReport();
			//MemberReport memr = new MemberReport();
			MemberAccount member = null
>>>>>>> branch 'master' of https://crthompson10@bitbucket.org/azaman2/spring23team17.git
			for (MemberAccount m : dc.getMemberList()) {
				if (m.getID() == id)
					member = m;
			}
			if (member != null) {
				MemberReport memr = new MemberReport(member);
				memr.generateReport();
			}
		}
		return;
	}
	
	public void requestAllReports(String type) {
		System.out.println("Manager Reports:\n");
		ManagerReport mr = new ManagerReport(dc);
		mr.generateReport();
		System.out.println("Provider Reports:\n");
		ProviderReport pr = new ProviderReport(dc);
		pr.generateReport();
		System.out.println("Member Reports:\n");
		MemberReport memr = new MemberReport(dc);
		memr.generateReport();
	}
}