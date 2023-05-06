package ChocAn;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampbellThompsonTests {

	public DataCenter dc;
	MemberAccount mem;
	
	@BeforeEach
	void setUp() throws Exception {
		dc = new DataCenter();
		
		//arbitrary values
		mem = new MemberAccount("Lewis", "Zanies", "12 Car street", "birg", "al", 18733, "1833392830");
		Service service = new Service("service", 123);
		
		dc.addMember(mem);
		dc.addService(service);
	}

	@Test
	void test() {
		fail();
	}
	
	/**
	 * test ProviderAccount Constructor
	 * test success
	 * @author Campbell Thompson (me)
	 */
	@Test
	void testProviderConstructor() {
		ProviderAccount prov = new ProviderAccount("Pachel", "Rierce", "382 Rocky Road", "Jackson", "mississppi", 18479, "1934858200");
		assertEquals(prov.getType(), "provider");	
	}
	
	/**
	 * test operator controller "delete member" function
	 * failure test
	 * @author Campbell Thompson (me)
	 */
	@Test
	void testDeleteMember() {
		OperatorController control = new OperatorController(dc);
		
		int size = dc.getMemberList().size();
		control.deleteMemberRecord(mem.getFirstName(), mem.getLastName());
		
		assertEquals(size - 1, dc.getMemberList().size());
		
	}
	
	/**
	 * test "verify member" function in account verifier class
	 * @author Wesley Junkins
	 */
	@Test
	void testVerifyMember() {
		AccountVerifier verifier = new AccountVerifier(dc);
		int status = verifier.verifyMemberAccount(mem.getID());
		assertEquals(status, mem.getStatus());
	}

}

