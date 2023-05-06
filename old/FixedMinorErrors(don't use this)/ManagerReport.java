package ChocAn;

public class ManagerReport {
	Account manager; //Will import Account class later.
	DataCenter providerList;
	//ArrayList<ProviderAccount> providerList; I don't think we actually need this if we are getting it from the data center
	int totalConsultations;
	int totalNumProviders;
	double totalFee;
	
	public void generateReport() {
		//List the providers to be paid
		System.out.println("Manager Report:\n");
		System.out.println("Providers to be paid: \n");
		
		providerList.getProviderList(); //Make this function print out the provider list / number of consultations each had, and their total fee for that week.
		
		//Number of consultations each had
		//Their total fee for that week
		//Total number of providers who provided services
		System.out.println("Total number of Providers: "+totalNumProviders+"\n");
		//Total number of consultations
		System.out.println("Total Consultations: "+totalConsultations+"\n");
		//Overall fee total
		System.out.println("Total Fee: "+totalFee+"\n");
	}

}
