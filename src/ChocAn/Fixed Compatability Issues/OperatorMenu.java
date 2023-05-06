package ChocAn;

import java.util.Scanner;

/**
 * Operator Menu class
 * gets user input to then send to controller class
 * @author Campbell Thompson
 */
public class OperatorMenu {
	
	private OperatorController controller;
	private Scanner scan;
	
	/**
	 * constructor
	 * @param data center - sent from main to pass on to controller, not really used in this class
	 */
	public OperatorMenu(DataCenter dc) {
		//controller instant
		controller = new OperatorController(dc);
		
		scan = new Scanner(System.in);
	}
	
	/**
	 * lists all possible actions for operators, 
	 * then sends user to other methods for further data collection
	 */
	public void listActions() {
		//control log out
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter the number for the aciton you would like to perform:");
			//print actions
			System.out.println("\t1. Add Record\n\t2. Edit Record\n\t3. Delete Record\n\t4. Log Out");
			int decision = 0;
					
			//check input valididty
			while (true) {
				decision = scan.nextInt();
				if (decision > 0 && decision < 5)
					break;
				System.out.println("Invalid Input. Please enter a number between 1 and 4.");
			}
		
			//send to controller 
			switch (decision) {
			case 1:
				addRecord();
				break;
			case 2:
				editRecord();
				break;
			case 3:
				deleteRecord();
				break;
			case 4:
				quit = true;
				break;
			default:
				System.out.println("No action could be performed. Try again.");
				break;
			}
		}
	}
	
	/**
	 * allows user to add either a provider or member account 
	 * prompts for account info then sends to controller
	 */
	public void addRecord() {
		//account variables
		String fn, ln, address, city, state, phone = "";
		int zip, type = 0;
		
		//prompt
		System.out.println("What type of account record would you like to add?");
		System.out.println("\t1. Member\n\t2. Provider");
		//check valid input
		while (true) {
			type = scan.nextInt();
			if (type < 3 && type > 0)
				break;
			System.out.println("Invalid input. Please enter an number between 1 and 2");
		}
		scan.nextLine();
		
		//prompt for more info
		System.out.println("Please enter the following information for the account you would like to add:");
		System.out.println("First Name:");
			fn = scan.nextLine();
		System.out.println("Last Name");
			ln = scan.nextLine();
		System.out.println("Street Address:");
			address = scan.nextLine();
		System.out.println("City");
			city = scan.nextLine();
		System.out.println("State:");
			state = scan.nextLine();
		System.out.println("Zip Code");
			zip = scan.nextInt();
		scan.nextLine();
		System.out.println("Phone Number");
			phone = scan.nextLine();
		
		//send info to controller
		switch (type) {
		case 1:
			controller.addMemberRecord(fn, ln, address, city, state, zip, phone);
			break;
		case 2:
			controller.addProviderRecord(fn, ln, address, city, state, zip, phone);
			break;
		default:
			System.out.println("Failed to add account. Try again.");
			break;
		}
	}
	
	/**
	 * allows user to delete either a member or provider account from data center
	 * prompts for name then sends to controller
	 */
	public void deleteRecord() {
		System.out.println("What kind of account would you like to delete?\n\t1. Member\n\t2. Provider");
		//check valid input
		int type = 0;
		while (true) {
			type = scan.nextInt();
			if (type < 3 && type > 0)
				break;
			System.out.println("Invalid input. Please enter an number between 1 and 2");
		}
		scan.nextLine();
		
		
		//prompts
		System.out.println("Please enter the following information for the account you want to delete:");
		System.out.println("First Name:");
			String fn = scan.nextLine();
		System.out.println("Last Name");
			String ln = scan.nextLine();
			
		//mem or prov
		switch (type) {
		case 1:
			controller.deleteMemberRecord(fn, ln);
			break;
		case 2:
			controller.deleteProviderRecord(fn, ln);
			break;
		default:
			System.out.println("Failed to delete account. Try again.");
			break;
		}
	}
	
	/**
	 * allows user to either change name, address, or phone number
	 * of a member or provider account.
	 * collects necessary info and sends to controller
	 * may make multiple edits without having to re-login
	 */
	public void editRecord() {
		System.out.println("What kind of account would you like to edit?\n\t1. Member\n\t2. Provider");
		int type = 0;
		//check valid input
		while (true) {
			type = scan.nextInt();
			if (type < 3 && type > 0)
				break;
			System.out.println("Invalid input. Please enter an number between 1 and 2");
		}
		scan.nextLine();
		
		//get current name
		System.out.println("Please enter the following information for the account you would like to edit:\nFirst Name:");
			String fn = scan.nextLine();
		System.out.println("Last Name:");
			String ln = scan.nextLine(); 
		
		boolean done = false;
		int taskDecision = 0;
		//loop to make multiple edits until quit
		while (!done) {
			System.out.println("What kind of edit would you like to make?");
			System.out.println("\t1. Change Name\n\t2. Change Address\n\t3. Change Phone Number");
			//check for valid input
			while (true) {
					taskDecision = scan.nextInt();
				if (taskDecision < 4 && taskDecision > 0)
					break;
				System.out.println("Invalid input. Please a number between 1 and 3.");
			}
			scan.nextLine();
			
			//switch between  edits
			switch (taskDecision) {
			//change name
			case 1:
				//get new name
				System.out.println("Please enter the following information:\nNew First Name:");
					String newFN = scan.nextLine();
				System.out.println("New Last Name:");
					String newLN = scan.nextLine();
				//pass to correct methods
				if (type == 1)
					controller.updateMemberName(fn, ln, newFN, newLN);
				else
					controller.updateProviderName(fn, ln, newFN, newLN);
				
				break;

			//change address
			case 2:
				//get updated info
				System.out.println("Please enter the following information:\nNew Street Address:");
					String address = scan.nextLine();
				System.out.println("New City");
					String city = scan.nextLine();
				System.out.println("New State");
					String state = scan.nextLine();
				System.out.println("New Zipcode");
					int zip = scan.nextInt();
				scan.nextLine();
				//pass to correct methods
				if (type == 1)
					controller.updateMemberAddress(fn, ln, address, city, state, zip);
				else
					controller.updateProviderAddress(fn, ln, address, city, state, zip);
				
				break;
			//change phone number
			case 3:
				System.out.println("Please enter the new phone number:");
					String num = scan.nextLine();
				//pass to correct methods
				if (type == 1)
					controller.updateMemberPhoneNum(fn, ln, num);
				else
					controller.updateProviderPhoneNum(fn, ln, num);
				
				break;
			default:
				break;
			//end switch case
			}
			
			//ask for other edits
			System.out.println("Would you like to make any more edits? yes/no");
			String quit = "";
			while (true) {
				quit = scan.nextLine();
				if (quit.toLowerCase().equals("yes") || quit.toLowerCase().equals("no"))
				{
					break;
				}
				System.out.println("Invalid input. Please enter either 'yes' or 'no'");
				
			}
			
			//quit
			if (quit.toLowerCase().equals("no"))
				done = true;
		//end while loop
		}
	}
	
}











