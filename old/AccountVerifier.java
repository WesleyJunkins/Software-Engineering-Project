package chocAn;

import java.util.Vector;

public class AccountVerifier {
	DataCenter dc = new DataCenter();
	
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
			return listToSearch.get(wasFoundAt).getStatus(); //1 for current member, 0 for suspended member, -1 for DNE user.
		}
		return -1;
	}
	
	public boolean verifyOperator(int ID) {
		Vector<Account> listToSearch = dc.getOperatorList();
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
			return true;
		}
		return false;
		
	}
	
	public boolean verifyManager(int ID) {
		Vector<Account> listToSearch = dc.getManagerList();
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
			return true;
		}
		return false;
	}
	
	public boolean verifyProviderAccount(int ID) {
		Vector<ProviderAccount> listToSearch = dc.getProviderList();
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
			return true;
		}
		return false;
	}
	
	public void displayError() {
		System.out.println("The account you searched does not exist.\n");
	}
}