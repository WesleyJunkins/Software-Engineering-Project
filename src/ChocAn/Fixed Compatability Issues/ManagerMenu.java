//By Wesley Junkins
//Javadocs are complete
package ChocAn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author wesjunkins
 *@version 4/27/2023
 */
public class ManagerMenu {
	
	private ManagerController controller;// = new ManagerController();
	
	/**
	 * List available actions
	 */
	public void listActions() {
		System.out.println("[1] Request Individual Reports\n[2] Request All Reports\n[3] Return to Main Menu");
	}
	
	/**
	 * Constructor
	 * @param dc for storing data
	 * @throws IOException for readLine
	 */
	public ManagerMenu(DataCenter dc) throws IOException {
		controller = new ManagerController(dc);
		int userChoice = 0;
		listActions();
		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);
		String fromUser = br.readLine();
		userChoice = Integer.parseInt(fromUser);
		while(userChoice != 3)
		{
			if(userChoice == 1) {
				System.out.println("Account type (enter: manager, provider, member: "); //Get the account type and account ID from here
				String accountType = br.readLine();
				System.out.println("Account ID: "); //Get the account type and account ID from here
				String accountIDSTRING = br.readLine();
				int accountID = Integer.parseInt(accountIDSTRING);
				//System.out.println("Before Calling the individual report function");
				controller.requestIndividualReports(accountType, accountID);
			}else if(userChoice == 2)
			{
				System.out.println("Account type: "); //Get the account type from here
				String accountType = br.readLine();
				controller.requestAllReports(accountType);
			}
			userChoice = 0;
			listActions();
			fromUser = br.readLine();
			userChoice = Integer.parseInt(fromUser);
		}
		return;
	}
	
}