package ChocAn;

public class ProviderReport {
	private ProviderAccount provider; //Will import this class later.
	
	public void generateReport() {
		//Right now, this will just output to the screen. Later, we might generate a string report and save it to a variable.
		System.out.println("Provider Report:\n");
		System.out.println("Name: "+provider.getName()+"\n"); 
		System.out.println("Number: "+provider.getID()+"\n"); 
		System.out.println("Address: "+provider.getFullAddress()+"\n");
		System.out.println("ZIP: "+provider.getZip()+"\n"); 
		
		provider.getServicesPerformed(); //Make this function print the services and their attributes one by one.
		
		System.out.println("Total Consultations: "+provider.getNumConsultations()+"\n");
		System.out.println("Total Week Fee: "+provider.getWeeklyFee()+"\n");
		
		//OR THIS (change function to string if you use this)
		//return("Provider Report:\nName: "+provider.getName()+"\nNumber: "+provider.getID()+"\nAddress: "+provider.getFullAddress()+"\nZIP: "+provider.getZip()+"\n"+provider.getServicesPerformed()+"\nTotal Consultations: "+provider.getNumConsultations()+"\nTotal Week Fee: "+provider.getWeeklyFee()+"\n");
	}

}
