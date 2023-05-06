package ChocAn;

public class ManagerReport {
	
	DataCenter dc;
	Account manager; //Will import Account class later.
	int totalConsultations = 0;
	int totalNumProviders = dc.getProviderList().size();
	double totalFee = 0;
	
	//Constructor
	public ManagerReport(DataCenter data, Account man) {
		dc = data;
		manager = man;
		for(int i = 0; i < dc.getProviderList().size(); i++)
		{
			totalFee = totalFee + (dc.getProviderList().get(i).getWeeklyFee());
			totalConsultations = totalConsultations + dc.getProviderList().get(i).getNumConsultations();
		}
	}
	
	
	public void generateReport() {
		//List the providers to be paid
		System.out.println("Manager Report:\n");
		System.out.println("Providers to be paid: \n");
		
		for(int i = 0; i < dc.getProviderList().size(); i++)
		{
			System.out.println(dc.getProviderList().get(i).getName()+"\n");
		}
		
		//Total number of providers who provided services
		System.out.println("Total number of Providers: "+totalNumProviders+"\n");
		//Total number of consultations
		System.out.println("Total Consultations: "+totalConsultations+"\n");
		//Overall fee total
		System.out.println("Total Fee: "+totalFee+"\n");
	}

}
