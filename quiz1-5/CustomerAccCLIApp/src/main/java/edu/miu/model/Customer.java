package edu.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Account account;

    public Customer (Long customerId, String firstName, String lastName, LocalDate dateOfBirth,
                     String accountNo, LocalDate dateOpened, Double balance) {
        if (accountNo == null) {
            throw new IllegalArgumentException("Account data is required");
        }
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.account = new Account(accountNo, dateOpened, balance);
    }

    public String toJSONString() {
        return String.format(
                """
                {
                    "customerId":%d,
                    "firstName":%s,
                    "lastName":%s,
                    "dateOfBirth":%s,
                    "account": {
                        "accountNo":%s,
                        "dateOpened":%s,
                        "balance":%.2f
                    }
                }""",
                customerId, firstName, lastName, dateOfBirth, account.getAccountNo(),
                account.getDateOpened(), account.getBalance()
        );
    }

}
