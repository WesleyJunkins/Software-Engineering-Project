/*Provider Account class
Written by Campbell Thompson*/

package ChocAn;

import java.util.ArrayList;

public class ProviderAccount extends Account {
	
	//variables
	private Vector<ServiceLog> servicesPerformed;
	private double weeklyFee;
	private int numConsultations;
	
	//constructor
	public ProviderAccount (String fn, String ln, String address, String ci, String st, int zip, String phone) {
		//pass to superclass
		super(fn, ln, "provider", address, ci, st, zip, phone);	
		
		//provider specifics
		servicesPerformed = new Vector<ServiceLog>();
		weeklyFee = 0.0;
		numConsultations = 0;
	}	
	
	//getters
	public Vector<ServiceLog> getServicesPerformed() {
		return servicesPerformed;
	}
	public getWeeklyFee() {
		return weeklyFee;
	}
	public getNumConsultations() {
		return numConsultations;
	}
	
	//reset provider accounts with the MAP
	public void weeklyReset() {
		servicesPerformed.clear();
		weeklyFee = 0.0;
		numConsultations = 0;
	}
	
	//add service to provider records
	public void addService(ServiceLog service) {
		servicesPerformed.add(service);
		weeklyFee += service.getFee();
		numConsultations++;
	}
		
}