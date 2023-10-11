package edu.miu.cs489.lab1b.model;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double montlyContribution;

    PensionPlan (String planReferenceNumber, LocalDate enrollmentDate, Double montlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.montlyContribution = montlyContribution;
    }
    PensionPlan () {

    }
}
