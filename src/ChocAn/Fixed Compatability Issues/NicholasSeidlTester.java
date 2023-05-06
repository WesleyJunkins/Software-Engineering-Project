//Nicholas Seidl
package ChocAn;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Vector;

import org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NicholasSeidlTester {

	DataCenter dc;
	Account a;
	ProviderAccount pA = new ProviderAccount("null", "null", "null", "null", "null", 0, "null");
	@Before
	public void setUp() throws Exception {
		dc = new DataCenter();
		a = new Account("", "", "", "", "", "", 0, "");
	}

	@Test // The addManager method was created by me
	public void testAddManagerAccount() {
		dc.addManager(a);
		assertEquals(dc.getManagerList().isEmpty(), false);
	}
	
	@Test // The searchByName method in the Provider Directory class was created by CampbellThompson
	public void testSearchByName()
	{
		dc.addService(new Service("Test", 0));
		assertEquals(dc.getProviderDirectory().searchByName("Test"), 0);
	}

	@Test // The getProviderList method was created by me
	public void testGetProviderList()
	{
		dc.addProvider(pA);
		Vector<ProviderAccount> providers = dc.getProviderList();
		ProviderAccount myAccount = new ProviderAccount("", "", "", "", "", 2, "");
		for(ProviderAccount acc: providers)
		{
			if(acc == pA)
			{
				myAccount = pA;
			}
		}
		assertEquals(myAccount, pA);
	}
}
