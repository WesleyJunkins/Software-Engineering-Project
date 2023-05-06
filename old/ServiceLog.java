package ChocAn;

public class ServiceLog {
    
    private ProviderAccount provider; //ProviderAccount class showing the service provider
    private MemberAccount member; //MemberAccount class showing the service recipient
    private Service service; //Service class showing the service provided
    private String date; //String showing the date the service was provided
    private String time; //String showing the time the service was provided
    private Double fee; //Double showing the fee charged for the service
    
    public ServiceLog(ProviderAccount provider, MemberAccount member, Service service, String date, String time, double fee) { //Constructor for ServiceLog
        this.provider = provider;
        this.member = member;
        this.service = service;
        this.date = date;
        this.time = time;
        this.fee = fee;
    }
    
    public ProviderAccount getProvider() { //Getters to access the member variables of the ServiceLog
        return provider;
    }
    
    public MemberAccount getMember() {
        return member;
    }
    
    public Service getService() {
        return service;
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
                "Service: \n" + service.getName() +
                "Date: \n" + date +
                "Time: \n" + time +
                "Fee: \n$" + fee;
    }
}