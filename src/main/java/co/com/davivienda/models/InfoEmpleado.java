package co.com.davivienda.models;

import java.util.Objects;

public class InfoEmpleado {

    private String empNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String terminationId;
    private JobTitle jobTitle;
    private Subnit subnit;
    private Location location;

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTerminationId() {
        return terminationId;
    }

    public void setTerminationId(String terminationId) {
        this.terminationId = terminationId;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Subnit getSubnit() {
        return subnit;
    }

    public void setSubnit(Subnit subnit) {
        this.subnit = subnit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InfoEmpleado that = (InfoEmpleado) o;
        return Objects.equals(empNumber, that.empNumber) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(terminationId, that.terminationId) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(subnit, that.subnit) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNumber, lastName, firstName, middleName, terminationId, jobTitle, subnit, location);
    }

    @Override
    public String toString() {
        return "InfoEmpleado{" +
                "empNumber='" + empNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", terminationId='" + terminationId + '\'' +
                ", jobTitle=" + jobTitle +
                ", subnit=" + subnit +
                ", location=" + location +
                '}';
    }
}
