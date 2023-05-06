package ChocAn;

public class ProviderController {
	
	private DataCenter dc;
	private AccountVerifier verifier;
	
	// constructor given datacenter
	public ProviderController(DataCenter center) {
		dc = center;
		verifier = new AccountVerifier;
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

	public void checkInMember(int Id, String date) {
		ServiceLog log = new ServiceLog;
		MemberAccount thisMember = getMember(Id);
		ProviderAccount thisProvider = 
		log.setMember(thisMember);
		log.setProvider(thisProvider);
		//FIXME set other variables
		//FIXME add to member & provider service vectors
	}
	
	public void requestProviderDirectory() {
		ProviderDirectory directory = dc.getProviderDirectory();
		//FIXME add directory print function, directory.print();
	}
	
	
}
