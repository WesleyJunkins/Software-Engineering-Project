/* Account class
   Written by Campbell Thompson
*/
package ChocAn;

public class Account {
	
	//variables
	private String firstName;
	private String lastName;
	private static int accountNum = 1000;
	private int ID;
	private String accountType;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String phoneNum;
	
	//constructor
	public Account (String fn, String ln, String ty, String address, String ci, String st, int zip, String phone) {
		firstName = fn;
		lastName = ln;
		
		//increase ids as more accounts are added
		accountNum++;
		ID = accountNum;
		
		//check for valid account type
		if (ty.toLowerCase().equals("member") || ty.toLowerCase().equals("provider") || ty.toLowerCase().equals("manager") || ty.toLowerCase().equals("operator"))
			accountType = ty.toLowerCase();
		
		streetAddress = address;
		city = ci;
		state = st;
		zipCode = zip;
		phoneNum = phone;
		
	}
	
	/*
	 * getters
	 */
	//Names
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public int getID() { 
		return ID;
	}
	
	public AccountType getType() {
		return type;
	}
	
	//addresses
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() { 
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getFullAddress() {
		return streetAddress + "\n" + city + ", " + state + " " + zipCode;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/*
	 * setters
	 */
	public void updateName(String fn, String ln) {
		firstName = fn;
		lastName = ln;
	}
	public void updateAddress(String address, String ci, String st, int zip) {
		streetAddress = address;
		city = ci;
		state = st;
		zipCode = zip;
	}
	public void updatePhoneNum(String num) {
		phoneNum = num;
	}
	
	//possible use for reports
	public String toString() {
		
	}
}



