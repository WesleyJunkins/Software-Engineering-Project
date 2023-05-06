package ChocAn;

//import java.util.ArrayList;
import java.util.Vector;

/**
 * ProviderAccount class
 * extends account to include extra information necessary for the provider
 * @author Campbell Thompson
 */
public class ProviderAccount extends Account {
	
	//variables
	private Vector<ServiceLog> servicesPerformed;
	private double weeklyFee;
	private int numConsultations;
	
	/**
	 * Automatically sets "type" to "provider" in super constructor
	 * takes no other @param different from super
	 */
	public ProviderAccount (String fn, String ln, String address, String ci, String st, int zip, String phone) {
		//pass to superclass
		super(fn, ln, "provider", address, ci, st, zip, phone);	
		
		//provider specifics
		servicesPerformed = new Vector<ServiceLog>();
		weeklyFee = 0.0;
		numConsultations = 0;
	}	
	
	/**
	 * returns vector of services performed that week
	 */
	public Vector<ServiceLog> getServicesPerformed() {
		return servicesPerformed;
	}
	/**
	 * returns weekly fee
	 */
	public double getWeeklyFee() {
		return weeklyFee;
	}
	/**
	 * returns number of consultations given that week
	 */
	public int getNumConsultations() {
		return numConsultations;
	}
	
	/**
	 * resets all provider-specific fields back to zero
	 * during the Main Accounting procedure
	 */
	public void weeklyReset() {
		servicesPerformed.clear();
		weeklyFee = 0.0;
		numConsultations = 0;
	}
	
	/**
	 * @param service - service to be added to servicesPerformed list
	 * increases the weekly fee and num consultations accordingly
	 */
	public void addService(ServiceLog service) {
		servicesPerformed.add(service);
		weeklyFee += service.getFee();
		numConsultations++;
	}
		
}