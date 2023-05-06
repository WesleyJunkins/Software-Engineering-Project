package ChocAn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SamWoodTester {
	
	public DataCenter dc;
	ProviderAccount provider;
	MemberAccount member; 
	
	@BeforeEach
	void setUp() throws Exception {
		dc = new DataCenter();
		provider = new ProviderAccount("Sam", "Wood", "931 Big Avenue", "paris", "france", 90210, "9313033214");
		member = new MemberAccount("Smid", "Gart", "205 Loftsville", "cookeville", "tennessee", 38501, "9310679372");
		
		dc.addProvider(provider);
		dc.addMember(member);
				
	}
	
	/**
	 * test MemberAccount Constructor.
	 * @author Sam Wood
	 */
	@Test
	void testMemberConstructor() {
		assertEquals(member.getType(), "member");
		assertEquals(member.getFirstName(), "Smid");
	}
	
	/**
	 * test validateMember function in ProviderMenu.
	 * @author Sam Wood
	 */
	@Test
	void testValidateMember() {
		ProviderMenu menu = new ProviderMenu(dc, provider.getID());
		assertEquals(menu.validateMember(1002),1);
	}
	
	/**
	 * test updateMemberName in OperatorController.
	 * @author Campbell Thompson
	 */
	@Test
	void testUpdateMemberName() {
		OperatorController controller = new OperatorController(dc);
		controller.updateMemberName(member.getFirstName(), member.getLastName(), "Nick", "Saban");
		assertEquals(member.getFirstName(), "Nick");
		assertEquals(member.getLastName(), "Saban");
	}
	
}