/**
 * Controller providing logic for all provider operations
 *  @author Dylan Iovino
 *  
 */
package ChocAn;

public class ProviderController {
	
	/**
	 * Reference to the data center class passed from Provider menu
	 */
	private DataCenter dc;
	/**
	 * Reference to new Account Verifier class
	 */
	private AccountVerifier verifier;
	/**
	 * ID of provider account currently logged in
	 */
	private int prAccountID;
	
	/**
	 * Constructor given data center and provider ID
	 * All calls to this class should use both arguments
	 */
	public ProviderController(DataCenter center, int someID) {
		dc = center;
		verifier = new AccountVerifier(dc);
		prAccountID = someID;
	}
	
	/**
	 * Returns member account given id
	 * @return memberAccount if found, else null
	 */
	public MemberAccount getMember(int Id) {
		for (MemberAccount member : dc.getMemberList()) {
			if (member.getID() == Id) {
				return member;
			}
		}
		return null;
	}
	
	/**
	 * Returns provider account given id
	 * @return providerAccount if found, else null
	 */
	public ProviderAccount getProviderInfo(int prAccountID) {
		for(int i = 0; i < dc.getProviderList().size(); i++)
		{
			if(prAccountID == dc.getProviderList().get(i).getID())
			{
				return dc.getProviderList().get(i);
			}
		}
		return null;
	}
	
	/**
	 * Calls accountVerifier using given ID and returns account status
	 * @return 1 for account active, 0 for suspended, -1 for nonexistant
	 */
	public int validateMember(int Id) {
		
		return verifier.verifyMemberAccount(Id);
	}

	/**
	 * Validates member
	 * If valid, creates a new service log using passed information
	 * Created service log is added to corresponding member and provider accounts
	 */
	public void checkInMember(int memId, int proId, String date, String time, Service fullService, double fee) {
		if (validateMember(memId) == 1) {
			ServiceLog log = new ServiceLog(getProviderInfo(prAccountID), getMember(memId), fullService, date, time, fee);
			MemberAccount thisMember = getMember(memId);
			dc.addServiceLog(log);
			getProviderInfo(prAccountID).addService(log);
			getMember(memId).addService(log);
		}
	}
	
	/**
	 * Calls provider directory print function
	 * Prints all services and their codes
	 */
	public void requestProviderDirectory() {
		dc.getProviderDirectory().printProviderDirectory();

	}
	
	
	
	
}
