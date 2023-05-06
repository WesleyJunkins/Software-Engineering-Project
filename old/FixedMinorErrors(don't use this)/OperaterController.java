/*
 * Operator Controller class
 * Interacts with data center to perform operator tasks
 * Created by Campbell Thompson
 */

package ChocAn;

public class OperatorController {
	
	private DataCenter dc;
	
	//constructor
	public OperatorController(DataCenter center) {
		dc = center;
	}
	
	//search methods
	public MemberAccount getMember(String fn, String ln) {
		for (MemberAccount member : dc.getMemberList()) {
			if (member.getLastName().equals(ln) && member.getFirstName().equals(fn))
				return member;
		}
		return null;
	}
	public ProviderAccount getProvider(String fn, String ln) {
		for (ProviderAccount provider : dc.getProviderList()) {
			if (provider.getLastName().equals(ln) && provider.getFirstName(fn))
				return provider;
		}
	}
	
	/*
	 * member updates
	 */
	public void deleteMemberRecord(String fn, String ln) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null) {
			dc.getMemberList().remove(mem);
			mem = null;
		}
	}
	//create new member account object from user input through menu class
	public void addMemberRecord(String fn, String ln, String address, String city, String state, int zip, String phone) {
		//MemberAccount acct = new MemberAccount(fn, ln, address, city, state, zip, phone);
		//add to data center
		dc.addMember(acct);
	}
	//edit member profile
	public void updateMemberName(String currFN, String currLN, String newFN, String newLN) {
		MemberAccount currMem = getMember(currFN, currLN);
		if (mem != null)
			mem.updateName(newFN, newLN);
	}
	public void updateMemberAddress(String fn, String ln, String address, String city, String state, int zip) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null)
			mem.updateMemberAddress(address, city, state, zip);
	}
	public void updateMemberPhoneNum(String fn, String ln, String num) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null)
			mem.updatePhoneNum(num);
	}
	
	/*
	 * provider updates
	 */
	//remove from dc
	public void deleteProviderRecord(String fn, String ln) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null) {
			dc.getProviderList().remove(provider);
			provider = null;
		}
	}
	//create new provider account
	public void addProviderRecord(String fn, String ln, String address, String city, String state, int zip, String phone) {
		ProviderAccount acct = new ProviderAccount(fn, ln, address, city, state, zip, phone);
		dc.getProviderList().add(acct);
	}
	//edits
	public void updateProviderName(String currFN, String currLN, String newFN, String newLN) {
		ProviderAccount provider = getProvider(currFN, currLN);
		if (provider != null)
			provider.updateName(newFN, newLN);
	}
	public void updateProviderMemberAddress(String fn, String ln, string address, string city, String state, int zip) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null)
			provider.updateAddress(address, city, state, zip);
	}
	public void updateProviderPhoneNum(String fn, String ln, String num) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null)
			provider.updatePhoneNum(num);
	}
	
}

















