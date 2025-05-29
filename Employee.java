package in.neosoft;

import java.util.*;
import java.util.stream.*;

public class Employee {
    private int id;
    private String name;
    private double salary;

    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

   
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

 
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 120000),
            new Employee(2, "Bob", 90000),
            new Employee(3, "Charlie", 120000),
            new Employee(4, "David", 70000),
            new Employee(5, "Eve", 50000)
        );

        double secondHighestSalary = employees.stream()
            .map(Employee::getSalary)
            .distinct()                         
            .sorted(Comparator.reverseOrder())  
            .skip(1)                            
            .findFirst()                        
            .orElse(-1d);                    
        System.out.println("Second highest salary is: " + secondHighestSalary);
    }
}
