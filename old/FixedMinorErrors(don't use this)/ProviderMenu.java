public package ChocAn; 
import java.util.Scanner; 

public class ProviderMenu() {
	private ProviderController controller; 
	private Scanner scan; 
    private AccountVerifier verifier; 
	
	ProviderMenu(DataCenter data) {
		controller = new ProviderController(data); 
		scan = new Scanner(System.in);
        verifier = new AccountVerifier();
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
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter ID, or type 2 to quit:")
		    ID = scan.nextInt();
		    int valid = validateMember(ID);
		    switch (valid) {
		    case 1:
		    	System.out.println("Validated");
		    	System.out.println("Enter Today's Date (MM-DD-YYYY format):");
		    	String date = scan.nextLine();
		    	controller.checkInMember(ID, date);

			case 2:
                quit = true; 
                System.out.println("Exiting...");
		    case 0:
		    	System.out.println("Member Suspended");
		    case -1:
		    	System.out.println("Invalid ID");
            case default: 
                System.out.println("Invalid number. Error");
		    }
        }
	}
	
	public int validateMember(int ID) {
		return verifier.verifyMemberAccount(ID);
	}
	public void requestProviderDirectory() {
		controller.requestProviderDirectory();
	}   
}
