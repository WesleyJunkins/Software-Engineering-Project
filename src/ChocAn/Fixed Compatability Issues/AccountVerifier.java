//By Wesley Junkins
//Javadocs are complete
package ChocAn;

import java.util.Vector;


/**
 * 
 * @author wesjunkins
 *@version 4/27/2023
 */
public class AccountVerifier {
	private DataCenter dc;
	
	/**
	 * 
	 * Constructor
	 * @param dataCenter for storing all data
	 */
	public AccountVerifier(DataCenter dataCenter) { //Added this constructor
		dc = dataCenter;
	}
	
	/**
	 * Verify member account
	 * @param ID for searching
	 * @return the status of the member account
	 */
	public int verifyMemberAccount(int ID) {
		Vector<MemberAccount> listToSearch = dc.getMemberList();
		boolean wasFound = false;
		int wasFoundAt = 0;
		for(int i = 0; i < listToSearch.size(); i++)
		{
			if(listToSearch.get(i).getID() == ID)
			{
				wasFound = true;
				wasFoundAt = i;
			}
		}
		if(wasFound == true)
		{
			//System.out.println("I MADE IT HERERERERREERERERERER\n");
			return listToSearch.get(wasFoundAt).getStatus(); //1 for current member, 0 for suspended member, -1 for DNE user.
		}
		return -1;
	}
	
	/**
	 * Verify Operator account
	 * @param ID for searching
	 * @return if the ID exists or not
	 */
	public boolean verifyOperator(int ID) {
		Vector<Account> listToSearch = dc.getOperatorList();
		boolean wasFound = false;
		//int wasFoundAt = 0;
		for(int i = 0; i < listToSearch.size(); i++)
		{
			if(listToSearch.get(i).getID() == ID)
			{
				wasFound = true;
				//wasFoundAt = i;
			}
		}
		if(wasFound == true)
		{
			return true;
		}
		return false;
		
	}
	
	/**
	 * Verify Manager account
	 * @param ID for searching
	 * @return if the ID exists or not
	 */
	public boolean verifyManager(int ID) {
		Vector<Account> listToSearch = dc.getManagerList();
		boolean wasFound = false;
		//int wasFoundAt = 0;
		for(int i = 0; i < listToSearch.size(); i++)
		{
			if(listToSearch.get(i).getID() == ID)
			{
				wasFound = true;
				//wasFoundAt = i;
			}
		}
		if(wasFound == true)
		{
			return true;
		}
		return false;
	}

	/**
	 * Verify Provider account
	 * @param ID for searching
	 * @return if the ID exists or not
	 */
	public boolean verifyProviderAccount(int ID) {
		Vector<ProviderAccount> listToSearch = dc.getProviderList();
		boolean wasFound = false;
		//int wasFoundAt = 0;
		for(int i = 0; i < listToSearch.size(); i++)
		{
			if(listToSearch.get(i).getID() == ID)
			{
				wasFound = true;
				//wasFoundAt = i;
			}
		}
		if(wasFound == true)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Display error if needed
	 */
	public void displayError() {
		System.out.println("The account you searched does not exist.\n");
	}
}