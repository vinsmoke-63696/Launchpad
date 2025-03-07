package Java.StreamAPI.AdvancedLevel;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Set;

import Java.Core.Employee;

public class EmployeeStream {

    public static void main(String[] args) {
        List<Employee> inputList = List.of(
            new Employee("Sunig", "IT", 10000),
            new Employee("Ravi", "IT", 20000),
            new Employee("Aamon", "Comp", 15000),
            new Employee("Adam", "Comp", 30000),
            new Employee("Charlie", "Medical", 45000),
            new Employee("Charlie", "Comp", 45000)
        );
        
        //Highest paid employee per department
        Map<String, Employee> output = inputList.stream().collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                Optional::get
                )
        ));
        System.out.println(output);

        //employee with second highest salary
        Employee emp = inputList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(emp);
        
        //Average salary per department
        Map<String, Double> avgSalary = inputList.stream().collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.averagingInt(Employee::getSalary)
        ));
        System.out.println(avgSalary);

        // Count Employee in each department
        Map<String, Long> count = inputList.stream().collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.counting()
        ));
        System.out.println(count);

        //convert emp list to sorted LinkedHashMap
        //Todo - Convert a List<Employee> into a LinkedHashMap<String, String> (ID → DepartmentName) sorted by salary in ascending order.

        LinkedHashMap<String, String> linkedHashMap = inputList.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .collect(Collectors.toMap(
            Employee::getDepartment,
            Employee::getName,
            (existing, old) -> existing,
            LinkedHashMap::new
        ));
            System.out.println(linkedHashMap);

        //Partiion employees by salary of >=20000
        Map<Boolean, List<Employee>> partition = inputList.stream().collect(Collectors.partitioningBy(
            n -> n.getSalary() >= 20000
        ));
        System.out.println(partition);

        //Employees with duplicate names - find names that appear more than once in employee list
        Set<String> set = new HashSet<String>();
        List<String> duplicates = inputList.stream().filter(
            n -> !set.add(n.getName()))
            .map(n-> n.getName()).toList();
        
        System.out.println(duplicates);

        //Employee names sorted by department then by  salary (highest to lowest), and return only the names
        List<String> names = inputList.stream().sorted(Comparator.comparing(Employee::getDepartment)
            .thenComparing(Comparator.comparing(Employee::getSalary).reversed())).map(n -> n.getName()).toList();

        System.out.println(names);
    }

            
    

    
}
