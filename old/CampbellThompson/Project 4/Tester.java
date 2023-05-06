package CampbellThompson.Project4;

public class Tester {
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Account account = new Account ("Campbell", "Thompson", 1, "member", "6005 Bostonian Ct", "Greensboro", "NC", "27455", "3365410190");
		
		System.out.println(account.getName());
	}
}