package jsonPlaceholder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TableRowDto {

    private String computerName;
    private Date introduced;
    private Date discontinued;
    private String company;

    public TableRowDto(String computerName, String introduced, String discontinued, String company) throws ParseException {
        this.computerName = computerName;
        this.introduced = getDateFromString(introduced);
        this.discontinued = getDateFromString(discontinued);
        this.company = company;
    }

    private Date getDateFromString(String dateLine) throws ParseException {
        if (dateLine.equals("-")) {
            return new Date(-1800, 0, 1);
        }
        else {
            return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateLine);
        }
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Date getIntroduced() {
        return introduced;
    }

    public void setIntroduced(Date introduced) {
        this.introduced = introduced;
    }

    public Date getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Date discontinued) {
        this.discontinued = discontinued;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
