package edu.miu.cs489.lab1b;

import edu.miu.cs489.lab1b.model.Employee;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class EmployeePensionPlansMgmtApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        var employees = List.of (
            new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,1,17), 80000.10,"111",LocalDate.of(2015,1,1),100.1),
            new Employee(2L, "Bernard", "Shaw", LocalDate.of(2018,10,3), null,"123",null,null),
            new Employee(3L, "Carly", "Agar", LocalDate.of(2014,5,16), 80000.10,"258",LocalDate.of(2015,1,1),100.1),
            new Employee(4L, "Wesley", "Schneider", LocalDate.of(2018,10,1), null,"563",null,null)
        );
      printMonthlyUpcomingEnrollees(employees);
    //  printAllEmployees(employees);
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
