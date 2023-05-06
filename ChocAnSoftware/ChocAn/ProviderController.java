package ChocAn;

public class ProviderController {
	
	private DataCenter dc;
	private AccountVerifier verifier;
	private int prAccountID;
	
	// constructor given datacenter
	public ProviderController(DataCenter center, int someID) {
		dc = center;
		verifier = new AccountVerifier(dc);
		prAccountID = someID;
	}
	
	public MemberAccount getMember(int Id) {
		for (MemberAccount member : dc.getMemberList()) {
			if (member.getID() == Id) {
				return member;
			}
		}
		return null;
	}
	
	public int validateMember(int Id) {
		
		return verifier.verifyMemberAccount(Id);
	}

	public void checkInMember(int memId, int proId, String date, String time, Service fullService, double fee) {
		ServiceLog log = new ServiceLog(getProviderInfo(prAccountID), getMember(memId), fullService, date, time, fee);
		MemberAccount thisMember = getMember(memId);
		dc.addServiceLog(log);
		getProviderInfo(prAccountID).addService(log);
		getMember(memId).addService(log);
		
//		ProviderAccount thisProvider = new ProviderAccount();
//		log.setMember(thisMember);
//		log.setProvider(thisProvider);
		
		//FIXME set other variables
		//FIXME add to member & provider service vectors
	}
	
	public void requestProviderDirectory() {
		dc.getProviderDirectory().printProviderDirectory();
		//FIXME add directory print function, directory.print();
	}
	
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
	
	
}
