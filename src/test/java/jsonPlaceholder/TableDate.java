package jsonPlaceholder;

public class TableDate {


    private String computerName;
    private String introduced;
    private String discontinued;
    private String company;

    public TableDate(String computerName, String introduced, String discontinued, String company) {
        this.computerName = computerName;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.company = company;
    }

    public String getComputerName() {
        return computerName;
    }
    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }
    public String getIntroduced() {
        return introduced;
    }
    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }
    public String getDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}
