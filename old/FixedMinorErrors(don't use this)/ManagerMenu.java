package ChocAn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManagerMenu {
	
	ManagerController controller = new ManagerController();
	
	public void listActions() {
		System.out.println("[1] Request Individual Reports\n[2] Request All Reports\n[3] Return to Main Menu");
	}
	
	//Constructor
	public ManagerMenu() throws IOException {
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