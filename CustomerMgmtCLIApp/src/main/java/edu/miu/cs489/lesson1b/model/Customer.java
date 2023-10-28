package edu.miu.cs489.lesson1b.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Customer {
    private Integer customerId;
    private String name;
}
