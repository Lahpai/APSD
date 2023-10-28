package edu.miu;

import edu.miu.model.Employee;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class EmployeePensionPlansMgmtApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello EmployeePensionPlansMgmtApp!" );

        var employees = List.of (
                new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,1,17), 80000.10,"EX1089",LocalDate.of(2023,1,17),100.00),
                new Employee(2L, "Bernard", "Shaw", LocalDate.of(2018,10,3), 197750.00,null,null,null),
                new Employee(3L, "Carly", "Agar", LocalDate.of(2014,5,16), 842000.75,"SM2307",LocalDate.of(2014,05,16),1555.50),
                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2018,11,02), 745000.00,null,null,null)
        );
          printAllEmployees(employees);
        //printMonthlyUpcomingEnrollees(employees);
    }

    private static void printAllEmployees(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    private static void printMonthlyUpcomingEnrollees(List<Employee> employees) {
        //TODO sort
        employees.stream().filter(Employee::isUpcomingEnrollee)
                .forEach(System.out::println);
    }
}