/**
 * Main Accounting Procedure class
 * runs all reports & clears all accounts
 * @author campbell Thompson
 */

package ChocAn;

public class MainAccountingProcedure {
	
	DataCenter dc;
	
	//constructor
	public MainAccountingProcedure(DataCenter data) {
		dc = data;
	}
	
	/**
	 * runs the procedure
	 */
	public void run() {
		
		//member reports first
		System.out.println("Member Reports:\n");
		for (MemberAccount member : dc.getMemberList()) {
			MemberReport report = new MemberReport(member);
			System.out.println(report.generateReport());
			member.weeklyReset();
		}
		
		//then provs
		System.out.println("Provider Reports:\n");
		for (ProviderAccount provider : dc.getProviderList()) {
			ProviderReport report = new ProviderReport(provider);
			report.generateReport();
			provider.weeklyReset();
		}
		
		//then managers
		System.out.println("Manager Report: ");
		for (Account manager : dc.getManagerList()) {
			ManagerReport report = new ManagerReport(manager, dc);
			//manager.generateReport();
			report.generateReport();
		}
	}
	
}