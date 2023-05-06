package ChocAn;

public class MemberReport {

    private MemberAccount member;

    // Constructor that takes a MemberAccount object and assigns it to member variable
    public MemberReport(MemberAccount member) {
        this.member = member;
    }

    // A method that generates a report string for the member
    public String generateReport() {
        // Create a new StringBuilder object to build the report string
        StringBuilder report = new StringBuilder();

        // Add the report header to the string
        report.append("Member Report:\n");
        report.append("Name: ").append(member.getName()).append("\n");
        report.append("ID: ").append(member.getID()).append("\n");
        report.append("Address: ").append(member.getAddress()).append("\n");
        report.append("City: ").append(member.getCity()).append("\n");
        report.append("State: ").append(member.getState()).append("\n");
        report.append("ZIP Code: ").append(member.getZip()).append("\n");

        // Add the member's provider information to the string
        report.append("Provider Name: ").append(member.getProviderName()).append("\n");
        report.append("Provider Number: ").append(member.getProviderNumber()).append("\n");

        // Add the date of service to the string
        report.append("Date of Service: ").append(new Date()).append("\n");

        // Add the services received by the member to the string
        report.append("Services Received:\n");
        for (Service service : member.getServicesReceived()) {
            report.append("- ").append(service.getName()).append("\n");
            report.append("  Fee: $").append(service.getFee()).append("\n");
        }

        // Add the total number of consultations and total weekly fee to the string
        report.append("Total Consultations: ").append(member.getNumConsultations()).append("\n");
        report.append("Total Week Fee: $").append(member.getWeeklyFee()).append("\n");

        // Return the generated report string
        return report.toString();
    }
}
