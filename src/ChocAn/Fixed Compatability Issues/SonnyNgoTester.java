package ChocAn;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SonnyNgoTester {

	public DataCenter dc;
	public MemberAccount memAccount;
	public AccountVerifier verifyMe;
	public ProviderAccount proAccount;
	public ProviderDirectory proDirectory;
	public Service myService;

    @Before
    public void setUp() throws Exception {
        dc = new DataCenter();
        proDirectory = new ProviderDirectory();
        myService = new Service("Physical Therapy", 1001);
        proDirectory.add(myService);
    }
    //Testing the GetMember method in my ServiceLog class (Sonny Ngo)
    @Test
    public void testGetMember() {
        ProviderAccount provider = new ProviderAccount("John Doe", "123 Main St", "Anytown", "IL", "12345", 123456789, "weekly report");
        MemberAccount member = new MemberAccount("Jane Smith", "456 Elm St", "Anytown", "IL", "12345", 987654321, "Blue Cross Blue Shield");
        String date = "2023-05-03";
        String time = "10:00:00";
        double fee = 150.0;
        ServiceLog serviceLog = new ServiceLog(provider, member, myService, date, time, fee);
        MemberAccount memberFromLog = serviceLog.getMember();
        assertEquals(member, memberFromLog);
    }
    //Testing the MemberReportConstructor method in my MemberReport class (Sonny Ngo)
    @Test
    public void testMemberReportConstructor() {
        MemberAccount member = new MemberAccount("Jane Smith", "456 Elm St", "Anytown", "IL", "12345", 987654321, "Blue Cross Blue Shield");
        MemberReport report = new MemberReport(member);
        assertEquals(member, report.member);
    }


    //Testing the GetFullServiceByCode method in Campbell Thompson's ProviderDirectory class
    @Test
    public void testGetFullServiceByCode() {
        assertEquals(myService, proDirectory.searchByCodeGetFullService(1001));
    }

}
