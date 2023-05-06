//By Wesley Junkins
package ChocAn;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tester
 * @author wesjunkins
 *@version 4/28/2023
 */
public class WesleyJunkinsTests {
	
	public DataCenter dc;
	public MemberAccount memAccount;
	public AccountVerifier verifyMe;
	public ProviderAccount proAccount;
	public ProviderDirectory proDirectory;
	public Service myService;

	/**
	 * Setup
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dc = new DataCenter();
		//memAccount = new MemberAccount("Wes", "Junkins", "123 Spooner Street", "Quahog", "MC", 35466, "2054637800");
		verifyMe = new AccountVerifier(dc);
		proAccount = new ProviderAccount("Some", "Name", "Road", "Tusc", "AL", 35466, "2054637800");
		proDirectory = new ProviderDirectory();
		myService = new Service("backRub", 1005);
		proDirectory.add(myService);
		dc.addProvider(proAccount);
		dc.addService(myService);
	}

	/**
	 * testMemberVerifier
	 * @author wesjunkins
	 */
	//Testing the Member Verifier that I, Wesley Junkins, implemented.
	@Test
	public void testMemberVerifier() {
		assertEquals(verifyMe.verifyMemberAccount(1001), -1); //We did not actually create a new member account.
	}
	
	/**
	 * testProviderVerifier
	 * @author wesjunkins
	 */
	//Testing the Provider Verifier that I, Wesley Junkins, implemented.
	@Test
	public void testProiderVerifier() {
		assertEquals(verifyMe.verifyProviderAccount(1001), true); //Newly created accounts start at 1001. Since this is the first one we created, it starts at 1001. TRUE means the account does exist.
	}
	
	/**
	 * testGetFullServiceByCode
	 * @author Campbell Thompson
	 */
	//Testing the Get Full Service function implemented by Campbell Thompson.
	@Test
	public void testGetFullServiceByCode() {
		assertEquals(proDirectory.searchByCodeGetFullService(1005).getName(), "backRub"); //We created this service and added it to the Data Center and Provider Directory. We search the code we gave it in the function in the provider directory and get the correct name of the function in return
	}
	
	/**
	 * testOperatorVerifier
	 * @author wesjunkins
	 */
	//Testing the Operator Verifier that I, Wesley Junkins, implemented
	@Test
	public void testOperatorVerifier() {
		assertFalse(verifyMe.verifyOperator(1001)); //We have created a provider account with the code 1001, not an operator account.
	}

}


