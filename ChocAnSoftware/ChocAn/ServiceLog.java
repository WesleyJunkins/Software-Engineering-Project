package ChocAn;

public class ServiceLog {
    
    private ProviderAccount provider; //ProviderAccount class showing the service provider
    private MemberAccount member; //MemberAccount class showing the service recipient
    private Service fullService; //Service class showing the service provided
    private String date; //String showing the date the service was provided
    private String time; //String showing the time the service was provided
    private Double fee; //Double showing the fee charged for the service
    
    public ServiceLog(ProviderAccount provider, MemberAccount member, Service fullService, String date, String time, Double fee) { //Constructor for ServiceLog
        this.provider = provider;
        this.member = member;
        this.date = date;
        this.time = time;
        this.fee = fee;
        this.fullService = fullService;
        
    }
    
    public ProviderAccount getProvider() { //Getters to access the member variables of the ServiceLog
        return provider;
    }
    
    public MemberAccount getMember() {
        return member;
    }
    
    public String getService() {
        return fullService.getName();
    }
    
    public int getServiceCode() {
    	return fullService.getCode();
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    public Double getFee() {
        return fee;
    }
    
    @Override
    public String toString() {
        return "Provider: \n" + provider.getName() +
                "Member: \n" + member.getName() +
                "Service: \n" + fullService.getName() +
                "Date: \n" + date +
                "Time: \n" + time +
                "Fee: \n$" + fee;
    }
}