
/**
 Provider menu class
 **/ 

package ChocAn; 
import java.util.Scanner; 

public class ProviderMenu {
	private ProviderController controller; 
	private Scanner scan; 
	//private ProviderAccount pr;
	private int proID;
	private DataCenter dc;
	
	/**
	 * constructor
	 * @param data center - sent from main to transfer to controller
	 * 		  prID - ID of provider, passed to controller when adding service
	 */
	
	ProviderMenu(DataCenter dc, int prID) {
		controller = new ProviderController(dc, prID); 
		scan = new Scanner(System.in);
		proID = prID;
		this.dc = dc;
	}
	
	/**
	 * Main menu loop
	 * Choose function, perform other methods
	 */
	
	public void listActions() {
		int userChoice;
		boolean quit = false; 
		while (!quit) {
			System.out.println("[1] Validate Member\n[2] Check In Member\n[3] Request Provider Directory\n[4] Exit Menu");
			userChoice = scan.nextInt();
		
			switch (userChoice) {
			case 1:
				System.out.println("Enter ID:");
				int id = scan.nextInt();
				//int valid = validateMember(ID);
				validateMember(id);
				break;
			case 2:
				checkInMember();
				break;
			case 3:
				requestProviderDirectory();
				break;
			case 4:
				quit = true; 
				System.out.println("Leaving Provider Menu...");
				break;
			default:
				System.out.println("Invalid number. Enter a number from 1-4.");
				break;
			}
			
		}
		
		/**
		 * Check member in, verify their ID, choose a service
		 * Passes onto controller for backend, adding services
		 * Necessary info: Date, time, fee, service code
		 * 
		 */
		
	}
	public void checkInMember() {
		int memID;
		System.out.println("Enter ID:");
		memID = scan.nextInt();
		scan.nextLine();
		int valid = validateMember(memID);
		switch (valid) {
		case 1:
			System.out.println("Validated");
			System.out.println("Enter Today's Date (MM-DD-YYYY format):");
			String date = scan.nextLine();
			System.out.println("Enter the Time (format: 1200 for 12:00): ");
			String serviceTime = scan.nextLine();
			System.out.println("Enter the Fee: ");
			double serviceFee = scan.nextDouble();
			scan.nextLine();
			System.out.println("Enter the Service Code: ");
			int serviceCode = scan.nextInt();
			scan.nextLine();
			
			controller.checkInMember(memID, proID, date, serviceTime, dc.getProviderDirectory().searchByCodeGetFullService(serviceCode), serviceFee);
			break;
		case 0:
			System.out.println("Member Suspended");
			break;
		case -1:
			System.out.println("Invalid Number");
			break;
		}
	}
	
	/**
	 * Verify member's ID is in memberList
	 * Mainly handled in controller
	 * @param ID of member
	 * @return status of member (valid, invalid, suspended)
	 */
	
	public int validateMember(int ID) {
		return controller.validateMember(ID);
	}
	
	/**
	 * Print out provider directory
	 * Mainly handled in ProviderDirectory class, controller as middleman
	 */
	
	public void requestProviderDirectory() {
		controller.requestProviderDirectory();
	}
}