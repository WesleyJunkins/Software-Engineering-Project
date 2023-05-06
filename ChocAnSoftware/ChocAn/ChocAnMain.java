/**
 * main runner class for chocan software
 * intitializes several arbitrary accounts and services in the data center
 * 
 * @author Campbell Thompson
 */

package ChocAn;

import java.io.IOException;
import java.util.Scanner;

public class ChocAnMain {
	
	//data center object
	private static DataCenter dc;
	
	/**
	 * initializes arbitrary data center variables
	 * then sends user to log in/
	 */
	public static void main(String args[]) throws IOException {
		
		dc = new DataCenter();
		
		/*filler accounts if needed*/
		MemberAccount mem1 = new MemberAccount("Campbell", "Thompson", "123 Street Road", "Greensboro", "North Carolina", 12345, "1234567890");
		MemberAccount mem2 = new MemberAccount("Elizabeth", "May", "82 Random Avenue", "Mobile", "Alabama", 37499, "8679756709");
		MemberAccount mem3 = new MemberAccount("Gabby", "Hernandez", "274 Place Place", "Miami", "Florida", 27183, "2940212938");
		
		ProviderAccount prov1 = new ProviderAccount("Nicole", "Jhun", "9002 First Street", "Atlanta", "Georgia", 12943, "2944492039");
		ProviderAccount prov2 = new ProviderAccount("Thomas", "Mayhall", "39 High Street", "Memphis", "Tennessee", 20354, "2930392183");
		
		Account man1 = new Account("Trina", "Locklear", "manager", "28 Bama Street", "Tuscaloosa", "Alabama", 29344, "1924402830");
		Account man2 = new Account("Nick", "Saban", "manager", "393 Walk of Champions", "Tuscaloosa", "Alabama", 982344, "9382838844");
				
		Account op1 = new Account("Brandon", "Smith", "operator", "1013 Sherwood Street", "Chicago", "Illinois", 60070, "8907545433");
		
		dc.addMember(mem1);
		dc.addMember(mem2);
		dc.addMember(mem3);
		
		dc.addProvider(prov1);
		dc.addProvider(prov2);
		
		dc.addManager(man1);
		dc.addManager(man2);
		
		dc.addOperator(op1);
		
		//make up services
		Service ser1 = new Service("Counseling Session", 1001);
			dc.addService(ser1);
		Service ser2 = new Service("Weekly Personalized Meal Plan", 1002);
			dc.addService(ser2);
		Service ser3 = new Service("Chocolate-Free Cooking Class", 1003);
			dc.addService(ser3);
		Service ser4 = new Service("Group Therapy Session", 1004);
			dc.addService(ser4);
		Service ser5 = new Service("Session with Personal Trainer", 1005);
			dc.addService(ser5);
			
		//FOR TESTING	
		ServiceLog service = new ServiceLog(prov1, mem1, ser1, "01-18-12", "1635",  12.12);
		prov1.addService(service);
		mem1.addService(service);
		dc.addServiceLog(service);
		//---
		
		login();
		
	}
	
	/**
	 * includes a while loop to either log in, run main accounting procedure,
	 * or shut down.
	 * allows multiple uses until shut down
	 */
	public static void login() throws IOException {
		Scanner scan = new Scanner(System.in);
		
		//while loop to do different logins
		boolean shutDown = false;
		while (!shutDown) {
			//welcome message
			System.out.println("Welcome to the Chocoholics Anonymous Employee Portal.\n\nPlease enter the number corresponding to the action you would like to take.");
			System.out.println("\t1. Log in as Provider\n\t2. Log in as Manager\n\t3. Log in as Operator\n\t4. Run Main Accounting Procedure\n\t5. System Shut Down");
				int decision = 0;
			//check valid input
			while (true) {
				decision = scan.nextInt();
				if (decision > 0 && decision < 6)
					break;
				System.out.println("Invalid input. Please enter a number between 1 and 5.");
			}
			
			//prompts for log in, else skip to shutdown
			if (decision < 4) {
				AccountVerifier verify = new AccountVerifier(dc);
				
				//get id
				System.out.println("Please enter your 4-digit ID number.");
					int id = scan.nextInt();
				
				//attempt login
				boolean validLogin = false;
				switch (decision) {
				//provider login
				case 1:
					validLogin = verify.verifyProviderAccount(id);
					//if valid, send to menu
					if (validLogin) {
						ProviderMenu menu = new ProviderMenu(dc, id);
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
				procedure.run(); //??? change later
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