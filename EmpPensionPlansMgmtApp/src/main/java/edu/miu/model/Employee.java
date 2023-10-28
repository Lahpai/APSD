package edu.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

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
