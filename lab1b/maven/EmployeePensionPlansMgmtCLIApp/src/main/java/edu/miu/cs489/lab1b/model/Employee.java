package edu.miu.cs489.lab1b.model;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary, String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = (planReferenceNumber == null) ? null : new PensionPlan(planReferenceNumber,enrollmentDate,monthlyContribution);
    }
    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

    public boolean isUpcomingEnrollee() {
        var nextMonthsDate = LocalDate.now().plusMonths(1L);
        var nextMonthsYear = nextMonthsDate.getYear();
        var nextMonthsMonth = nextMonthsDate.getMonth();
        var enrollQualificationDate = employmentDate.plusYears(5L);
        return ((enrollQualificationDate.getYear() == nextMonthsYear)
        && (enrollQualificationDate.getMonth().equals(nextMonthsMonth))
        &&(pensionPlan == null));
    };
}
