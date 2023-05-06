package ChocAn;

import java.util.Vector;

public class MemberAccount extends Account {

    // Class for a member account.
    // Status: 1 indicates current member, 0 indicates suspended member

    int status; 
    Vector<ServiceLog> servicesAccessed;

    public MemberAccount() {
		servicesAccessed = new Vector<ServiceLog>();
        status = 1;
    }

	public MemberAccount (String fn, String ln, String address, String ci, String st, int zip, String phone) {
		//pass to superclass
		super(fn, ln, "member", address, ci, st, zip, phone);  
   
    	//member specifics
    	servicesAccessed= new Vector<ServiceLog>();
    	status = 1;
	}​

    public void weeklyReset() {
        for (int i = 0; i < servicesAccessed.size(); i++) {
            servicesAccessed.remove(i);
        }
    }

    public int getStatus() {
        return status; 
    }

    public List<ServiceLog> getServicesAccessed() {
        return servicesAccessed;
    }

    public void updateStatus(int s) {
        status = s;
    }

    public void addService(ServiceLog service) {
        servicesAccessed.add(service);
    }

    
}