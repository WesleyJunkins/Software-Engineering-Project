//By Wesley Junkins
//Javadocs are complete
package ChocAn;

/**
 * 
 * @author wesjunkins
 *@version 4/28/2023
 */
public class ManagerReport {
	
	Account manager; //Will import Account class later.
	int totalConsultations = 0;
	int totalNumProviders;// = dc.getProviderList().size();
	double totalFee = 0;
	DataCenter dataCenter;
	
	/**
	 * Constructor
	 * @param m for holding an account
	 * @param dc for storing data
	 */
	public ManagerReport(Account m, DataCenter dc) {
		manager = m;
		dataCenter = dc;
		totalNumProviders = dc.getProviderList().size();
		
		for(int i = 0; i < dc.getProviderList().size(); i++)
		{
			totalFee = totalFee + dc.getProviderList().get(i).getWeeklyFee();
			totalConsultations = totalConsultations + dc.getProviderList().get(i).getNumConsultations();
		}
	}
	
	/**
	 * Generate manager report
	 */
	public void generateReport() {
		//List the providers to be paid
		System.out.println("Manager Report:\n");
		System.out.println("\tProviders to be paid: \n");
		
		for(int i = 0; i < dataCenter.getProviderList().size(); i++)
		{
			System.out.println("\tName: "+dataCenter.getProviderList().get(i).getName());
			System.out.println("\tConsultations: "+dataCenter.getProviderList().get(i).getNumConsultations());
			System.out.println("\tFee: $"+dataCenter.getProviderList().get(i).getWeeklyFee());
		}
		
		//Total number of providers who provided services
		System.out.println("\tTotal number of Providers: "+totalNumProviders+"\n");
		//Total number of consultations
		System.out.println("\tTotal Consultations: "+totalConsultations+"\n");
		//Overall fee total
		System.out.println("\tTotal Fee: "+totalFee+"\n");
	}

}
