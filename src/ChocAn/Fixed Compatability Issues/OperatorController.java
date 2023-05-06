package ChocAn;

/**
 * Operator Controller class
 * Interacts with data center to perform operator tasks
 * Created by Campbell Thompson
 */

public class OperatorController {
	
	private DataCenter dc;
	
	/**
	 * constructor
	 * @param center - data center object to search for other accounts, sent from menu
	 */
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
			if (provider.getLastName().equals(ln) && provider.getFirstName().equals(fn))
				return provider;
		}
		return null;
	}
	
	/**
	 * deletes member
	 */
	public void deleteMemberRecord(String fn, String ln) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null) {
			dc.getMemberList().remove(mem);
			mem = null;
		}else
		{
			System.out.println("Record not found");
		}
	}
	/**
	 * create new member account object from user input through menu class
	 */
	public void addMemberRecord(String fn, String ln, String address, String city, String state, int zip, String phone) {
		MemberAccount acct = new MemberAccount(fn, ln, address, city, state, zip, phone);
		//add to data center
		dc.addMember(acct);
	}
	/** 
	 * changes member name
	 */
	public void updateMemberName(String currFN, String currLN, String newFN, String newLN) {
		MemberAccount mem = getMember(currFN, currLN);
		if (mem != null)
		{
			mem.updateName(newFN, newLN);
		}else
		{
			System.out.println("Record not found");
		}
	}
	/**
	 * changes member address
	 */
	public void updateMemberAddress(String fn, String ln, String address, String city, String state, int zip) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null)
		{
			mem.updateAddress(address, city, state, zip);
		}else
		{
			System.out.println("Record not found");
		}
	}
	/**
	 * changes member phone num
	 */
	public void updateMemberPhoneNum(String fn, String ln, String num) {
		MemberAccount mem = getMember(fn, ln);
		if (mem != null)
		{
			mem.updatePhoneNum(num);
		}else
		{
			System.out.println("Record not found");
		}
	}
	
	/**
	 * deletes provider account from data center, then sets to null
	 */
	public void deleteProviderRecord(String fn, String ln) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null) {
			dc.getProviderList().remove(provider);
			provider = null;
		}else
		{
			System.out.println("Record not found");
		}
	}
	/**
	 * creates new provider account
	 */
	public void addProviderRecord(String fn, String ln, String address, String city, String state, int zip, String phone) {
		ProviderAccount acct = new ProviderAccount(fn, ln, address, city, state, zip, phone);
		dc.getProviderList().add(acct);
	}
	/**
	 * changes provider name
	 */
	public void updateProviderName(String currFN, String currLN, String newFN, String newLN) {
		ProviderAccount provider = getProvider(currFN, currLN);
		if (provider != null)
			provider.updateName(newFN, newLN);
	}
	/**
	 * changes provider address
	 */
	public void updateProviderAddress(String fn, String ln, String address, String city, String state, int zip) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null)
			provider.updateAddress(address, city, state, zip);
	}
	/**
	 * changes provider phone number
	 */
	public void updateProviderPhoneNum(String fn, String ln, String num) {
		ProviderAccount provider = getProvider(fn, ln);
		if (provider != null)
			provider.updatePhoneNum(num);
	}
	
}

















