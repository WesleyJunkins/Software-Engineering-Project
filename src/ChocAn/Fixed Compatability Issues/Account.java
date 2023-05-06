/**
 * The class is to store all needed information used in each report type
 * @author Campbell Thompson
 */

package ChocAn;

/**
 * Account class
 * The class is to store all needed information used in each report type
 * @author Campbell Thompson
 */
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
	
	/**
	 * This constructor accepts data from either the main, member or provider subclasses, or the operator controller
	 * Contains the name, full address, account type, and phone number of each person
	 * @param fn, ln - String value for first name, last name
	 * @param address, ci, st - Strings containing street address, city, and state
	 * @param zip - int containing zipcode
	 * @param phone - String containing phone number
	 */
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
	
	/**
	 * returns first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * returns last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * returns full name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	/**
	 * returns account id
	 */
	public int getID() { 
		return ID;
	}
	/**
	 * returns account type
	 */
	public String getType() {
		return accountType;
	}
	
	/**
	 * returns street address
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * returns city
	 */
	public String getCity() { 
		return city;
	}
	/**
	 * returns state
	 */
	public String getState() {
		return state;
	}
	/**
	 * return zip code
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * returns fully formatted address
	 */
	public String getFullAddress() {
		return streetAddress + "\n\t\t" + city + ", " + state + " " + zipCode;
	}
	/**
	 * returns phone number
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * setters
	 */
	/**updates account name*/
	public void updateName(String fn, String ln) {
		firstName = fn;
		lastName = ln;
	}
	/**
	 * updates full address
	 * same @param descriptions as constructor
	 */
	public void updateAddress(String address, String ci, String st, int zip) {
		streetAddress = address;
		city = ci;
		state = st;
		zipCode = zip;
	}
	/**
	 * updates phone number
	 */
	public void updatePhoneNum(String num) {
		phoneNum = num;
	}
	
}



