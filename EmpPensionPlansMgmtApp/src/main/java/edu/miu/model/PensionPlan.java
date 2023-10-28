package edu.miu.model;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;

    PensionPlan (String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    PensionPlan () {

    }
}
