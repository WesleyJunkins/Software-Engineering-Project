package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Vector;

import org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DylanIovinoTests {
	
	public DataCenter dc;
	public MemberAccount memAcc;
	public ProviderAccount provAcc;
	public AccountVerifier verifier;
	public Service testService;
	public ProviderMenu pMenu;
	public OperatorController oCont;
	
	@Before
	public void initialize() throws Exception {
		dc = new DataCenter();
		memAcc = new MemberAccount("Dylan", "Iovino", "4 Main St", "Canton", "GA", 30114, "1234567890");
		dc.addMember(memAcc);
		provAcc = new ProviderAccount("Jeremy", "Jones", "5 Main St", "Canton", "GA", 30114, "2345678901");
		dc.addProvider(provAcc);
		verifier = new AccountVerifier();
		testService = new Service("Therapy", 1000);
		dc.addService(testService);
		pMenu = new ProviderMenu(dc, 1002);
		oCont = new OperatorController(dc);
		
	}
	
	// Testing the positive outcome of the verify member function
	@Test
	public void validMemberVerify() {
		assertEquals(verifier.verifyMemberAccount(1001), 1);
	}
	
	// Testing the negative outcome of checking in a nonexistant member
	@Test
	public void failMemberCheckIn() {
		fail(pMenu.checkInMember());
	}
	
	// Testing the name change function for operator
	@Test
	public void editMemberAccount() {
		oCont.updateMemberName("Dylan", "Iovino", "James", "Iovino");
		assertEquals(dc.getMemberList()[0].getName(), "James Iovino");
	}
	
}