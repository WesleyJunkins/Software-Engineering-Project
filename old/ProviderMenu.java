package ChocAn; 
import java.util.Scanner; 

public class ProviderMenu() {
	private ProviderController controller; 
	private Scanner scan; 
	
	ProviderMenu() {
		controller = new ProviderController(); 
		scan = new Scanner(System.in);
	}
	
	public void listActions() {
		int userChoice;
		boolean quit = false; 
		while (!quit) {
			System.out.println("[1] Validate Member\n[2] Check In Member\n[3] Request Provider Directory\n[4] Exit Menu");
			userChoice = scan.nextInt();
		
			switch (userChoice) {
			case 1:
				validateMember();
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
			default:
				System.out.println("Invalid number. Enter a number from 1-4.");
				break;
			}
			
		}
		
	}
	public void checkInMember() {
		int ID;
		System.out.println("Enter ID:")
		ID = scan.nextInt();
		int valid = validateMember(ID);
		switch (valid) {
		case 1:
			System.out.println("Validated");
			System.out.println("Enter Today's Date (MM-DD-YYYY format):");
			String date = scan.nextLine();
			
			controller.checkInMember(String date);
			
		case 0:
			System.out.println("Member Suspended");
		case -1:
			System.out.println("Invalid Number");
		}
	}
	
	public int validateMember(int ID) {
		return controller.validateMember(ID);
	}
	public void requestProviderDirectory() {
		controller.requestProviderDirectory();
	}
}