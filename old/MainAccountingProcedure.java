/*
 * Main Accounting Procedure class
 * written by campbell Thompson
 */

package ChocAn;

public class MainAccountingProcedure {
	
	DataCenter dc;
	
	//constructor
	public MainAccountingProcedure(DataCenter data) {
		dc = data;
	}
	
	//prints literally all reports to screen
	public void run() {
		
		//member reports first
		for (MemberAccount member : dc.getMemberList()) {
			MemberReport report = new MemberReport(member);
			report.generateReport();
			member.weeklyReset();
		}
		
		//then provs
		for (ProviderAccount provider : dc.getProviderList()) {
			ProviderReport report = new ProviderReport(provider);
			report.generateReport();
			provider.weeklyReset();
		}
		
		//then managers
		for (Account manager : dc.getManagerList()) {
			ManagerReport report = new ManagerReport(dc, manager);
			report.generateReport();
		}
	}
	
}