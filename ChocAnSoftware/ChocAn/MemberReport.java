package ChocAn;

import java.util.Date;

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
        report.append("Name: ").append(member.getName());
        report.append("\tID: ").append(member.getID());
        report.append("\tAddress: ").append(member.getFullAddress());
        report.append("\tCity: ").append(member.getCity());
        report.append("\tState: ").append(member.getState());
        report.append("\tZIP Code: ").append(member.getZipCode());

//        // Add the member's provider information to the string
//        report.append("\tProvider Name: ").append(member.getProviderName());
//        report.append("\tProvider Number: ").append(member.getProviderNumber());
//
//        // Add the date of service to the string
//        report.append("Date of Service: ").append(new Date());

        // Add the services received by the member to the string
        report.append("Services Received:\n");
        for (ServiceLog service : member.getServicesAccessed()) {
            // Add the member's provider information to the string
            report.append("\t\tProvider Name: ").append(member.getProviderName());
            report.append("\t\tProvider Number: ").append(member.getProviderNumber());

            // Add the date of service to the string
            report.append("\t\tDate of Service: ").append(new Date());
            report.append("- ").append(service.getService());
            report.append("\t\tFee: $").append(service.getFee());
        }

        // Add the total number of consultations and total weekly fee to the string
        report.append("\tTotal Consultations: ").append(member.getNumConsultations());
        //report.append("Total Week Fee: $").append(member.getWeeklyFee()).append("\n");

        // Return the generated report string
        return report.toString();
    }
}
