package edu.miu;

import edu.miu.model.Customer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class BankApp
{
    public static void main( String[] args )
    {

        System.out.println( "Hello BankApp!" );

    var customers = List.of(
            new Customer(1L, "Daniel", "Agar", LocalDate.of(1978, 01, 17),
                    "SV1089", LocalDate.of(2013, 10, 10), 950.00),
            new Customer(2L, "Benard", "Shaw", LocalDate.of(2004, 10, 9),
                    "SV1089", LocalDate.of(2013, 10, 9), 100005.00),
            new Customer(3L, "Carly", "DeFiori", LocalDate.of(2014, 05, 16),
                    "SV1089", LocalDate.of(2019, 11, 04), 1555.50),
            new Customer(4L, "Wesley", "Schneider", LocalDate.of(2001, 11, 02),
                    "SV1089", LocalDate.of(2012, 1, 15), 125009.55)
            );
   // printAllCustomers(customers);
        printPlatinumAccountCustomers(customers);
    }

    private static void printAllCustomers(List<Customer> customers) {
        if(customers.size() > 0) {
            System.out.println("[");
            var sortedCustomers = customers.stream().sorted(Comparator.comparing(Customer::getLastName));
            System.out.println(sortedCustomers.map(c -> c.toJSONString()).collect(Collectors.joining(",")));
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }

    private static void printPlatinumAccountCustomers(List<Customer> customers) {
        if(customers.size() > 0){
            System.out.println("[");
            var customerSortedByBalanceDesc = customers.stream()
                    .filter(s->s.getAccount().isPlatinum())
                    .sorted(Comparator.comparing((Customer c) -> c.getAccount().getBalance(), Comparator.reverseOrder())
                            .thenComparing((Customer c) -> c.getAccount().getAccountNo(), Comparator.reverseOrder()));

            var customerSortedByBalanceDescAndAccountNo = customerSortedByBalanceDesc
                    .sorted(Comparator.comparing(c -> c.getAccount().getAccountNo()));
            System.out.println(customerSortedByBalanceDescAndAccountNo.map(c->c.toJSONString())
                    .collect(Collectors.joining(",")));
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }
}
