package ChocAn;

public class ManagerController {
	DataCenter dc = new DataCenter();
	
	public void requestIndividualReports(String type, int id) { //This should somehow search for a specific ID of the report to print. Maybe search for the ID in a DataCenter variable, and then pass that memberAccount to memberReport(memberAccount);
		if(type == "manager")
		{
			ManagerReport mr = new ManagerReport();
			mr.generateReport();
		}else
		if(type == "provider")
		{
			ProviderReport pr = new ProviderReport();
			pr.generateReport();
		}else
		if(type == "member")
		{
			dc.
			MemberReport memr = new MemberReport();
			memr.generateReport();
		}
		return;
	}
	
	public void requestAllReports(String type) {
		System.out.println("Manager Reports:\n");
		ManagerReport mr = new ManagerReport();
		mr.generateReport();
		System.out.println("Provider Reports:\n");
		ProviderReport pr = new ProviderReport();
		pr.generateReport();
		System.out.println("Member Reports:\n");
		MemberReport memr = new MemberReport();
		memr.generateReport();
	}
}