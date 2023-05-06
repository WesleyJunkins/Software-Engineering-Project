//By Wesley Junkins
package ChocAn;

public class ProviderReport {
	private ProviderAccount provider; //Will import this class later.
	
	public ProviderReport(ProviderAccount p) {
		provider = p;
	}
	
	public void generateReport() {
		//Right now, this will just output to the screen. Later, we might generate a string report and save it to a variable.
		System.out.println("Name: "+provider.getName()); 
		System.out.println("\tNumber: "+provider.getID()); 
		System.out.println("\tAddress: "+provider.getFullAddress());
		System.out.println("\tZIP: "+provider.getZipCode()); 
		
		for(int i = 0; i < provider.getServicesPerformed().size(); i++)
		{
			ServiceLog service = provider.getServicesPerformed().get(i);
			System.out.println("\t\t"+service.getDate());
			System.out.println("\t\t"+service.getTime());
			System.out.println("\t\t"+service.getMember().getName());
			System.out.println("\t\t"+service.getMember().getID());
			System.out.println("\t\t"+service.getService());
			System.out.println("\t\t"+service.getFee());
		}
		provider.getServicesPerformed();
		
		System.out.println("\tTotal Consultations: "+provider.getNumConsultations());
		System.out.println("\tTotal Week Fee: "+provider.getWeeklyFee());
		
		//OR THIS (change function to string if you use this)
		//return("Provider Report:\nName: "+provider.getName()+"\nNumber: "+provider.getID()+"\nAddress: "+provider.getFullAddress()+"\nZIP: "+provider.getZip()+"\n"+provider.getServicesPerformed()+"\nTotal Consultations: "+provider.getNumConsultations()+"\nTotal Week Fee: "+provider.getWeeklyFee()+"\n");
	}

}
