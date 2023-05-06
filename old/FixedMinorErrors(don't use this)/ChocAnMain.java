/*
 * main runner class for chocan software
 * written by Campbell Thompson
 */

package ChocAn;

public class ChocAnMain {
	
	//data center object
	private DataCenter dc;
	
	//main
	public static void main(String args[]) {
		
		dc = new DataCenter();
		
		/*filler accounts if needed*/
		MemberAccount mem1 = new MemberAccount("Campbell", "Thompson", "123 Street Road", "Greensboro", "North Carolina", 12345, "1234567890");
		MemberAccount mem2 = new MemberAccount("Elizabeth", "May", "82 Random Avenue", "Mobile", "Alabama", 37499, "8679756709");
		MemberAccount mem3 = new MemberAccount("Gabby", "Hernandez", "274 Place Place", "Miami", "Florida", 27183, "2940212938");
		
		ProviderAccount prov1 = new ProviderAccount("Nicole", "Jhun", "9002 First Street", "Atlanta", "Georgia", 12943, "2944492039");
		ProviderAccount prov2 = new ProviderAccount("Thomas", "Mayhall", "39 High Street", "Memphis", "Tennessee", 20354, "2930392183");
		
		Account man1 = new Account("Trina", "Locklear", "manager", "28 Bama Street", "Tuscaloosa", "Alabama", 29344, "1924402830");
		Account man2 = new Account("Nick", "Saban", "manager", "393 Walk of Champions", "9382838844")
				
		Account op1 = new Account("Brandon", "Smith", "operator", "1013 Sherwood Street", "Chicago", "Illinois", 60070, "8907545433"); 
		
		login();
		
	}
	
	//method to send user to proper menu
	public void login() {
		Scanner scan = new Scanner(System.in);
		
		//while loop to do different logins
		boolean shutDown = false;
		while (!shutDown) {
			//welcome message
			System.out.println("Welcome to the Chocoholics Anonymous Employee Portal.\n\nPlease enter the number corresponding to the action you would like to take.");
			System.out.println("\t1. Log in as Provider\n\t2. Log in as Manager\n\t3. Log in as Operator\n\t4. Run Main Accounting Procedure\n\t5. System Shut Down");
				int decision = 0;
			//check valid input
			while (1) {
				type = scan.nextInt();
				if (decision > 0 && decision < 6)
					break;
				System.out.println("Invalid input. Please enter a number between 1 and 5.");
			}
			
			//prompts for log in, else skip to shutdown
			if (decision < 4) {
				AccountVerifier verify = new AccountVerifier();
				
				//get id
				System.out.println("Please enter your 4-digit ID number.");
					int id = scan.nextInt();
				
				//attempt login
				boolean validLogin = false;
				switch (decision) {
				//provider login
				case 1:
					validLogin = verify.verifyProvider(id);
					//if valid, send to menu
					if (validLogin) {
						ProviderMenu menu = new ProviderMenu(dc);
						System.out.println("Succesful login! Navigating to the Provider portal...");
						menu.listActions();
					}
					else
						System.out.println("Login failed. Please try again or select a different account type.");
					break;
				case 2:
					validLogin = verify.verifyManager(id);
					if (validLogin) {
						System.out.println("Succesful login! Navigating to the Manager portal...");
						ManagerMenu menu = new ManagerMenu(dc);
					}
					else
						System.out.println("Login failed. Please try again or select a different account type.");
					break;
				case 3:
					validLogin = verify.verifyOperator(id);
					if (validLogin) {
						OperatorMenu menu = new OperatorMenu(dc);
						System.out.println("Successful login! Navigating to Operator portal...");
						menu.listActions();
					}
					else
						System.out.println("Login failed. Please try again or select a different account type.");
					break;
				default:
					System.out.println("Login failed. Please try again or select a different account type.");
					break;
				//end switch case
				}
			}
			//run MAP
			else if (decision == 4) {
				MainAccountingProcedure procedure = new MainAccountingProcedure(dc);
				//procedure.run(); ??? change later
			}
			//quit to system shut down
			else {
				shutDown = true;
				System.out.println("System shutting down...");
			}
			//will keep looping to login or MAP until shutdown
		}
	}
	
}