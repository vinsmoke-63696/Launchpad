package Java.StreamAPI.AdvancedLevel;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Java.Core.Employee;
 
//1. Find the top 3 highest paid employees and collect them into List<Employee>  (Sorting + Collecting)
//2. Group employees by department, but in each department, employee should be sorted by salary (highest first)  (Grouping + Sorting)
//3. Find the most frequent character and its count in string (Grouping + Counting)
//4. Convert List to sorted LinkedHashMap (ToMap + Sorting) -- You have a list of Product objects with id, name, and price. 
//      Convert this list into a LinkedHashMap<Integer, String> (where keys are product IDs and values are product names), but store them in ascending order of price.
public class CollectorsAndComparators {

    //Assume product as CollectorsAndComparators
    int id;
    String name;
    int price;
    
    @Override
    public String toString() {
        return "CollectorsAndComparators [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    public CollectorsAndComparators(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        //CollectorsAndComparators cac = new CollectorsAndComparators();
        List<Employee> inputList = List.of(
            new Employee("Sunig", "IT", 10000),
            new Employee("Ravi", "IT", 20000),
            new Employee("Aamon", "Comp", 15000),
            new Employee("Adam", "Civil", 30000),
            new Employee("Charlie", "Medical", 45000)
        );

        firstProblem(inputList);
        secondProblem(inputList);
        thirdProblem("hello world");
        fourthProblem();
    }

   static void firstProblem(List<Employee> inputList){
        List<Employee> output = inputList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList();
        System.out.println(output);     
    }

    static void secondProblem(List<Employee> inputList){
        Map<String, List<Employee>> output = inputList.stream().collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList()
                )
        )); 
        System.out.println(output);
    }

    static void thirdProblem(String input){

    }

    static void fourthProblem(){

        List<CollectorsAndComparators> productList = List.of( new CollectorsAndComparators(1, "toy", 50), new CollectorsAndComparators(2, "bat", 200)
        , new CollectorsAndComparators(3, "ball", 10), new CollectorsAndComparators(4, "gloves", 100));

        LinkedHashMap<Integer, String> output = productList.stream()
        .sorted(Comparator.comparingInt(CollectorsAndComparators::getPrice)).collect(
            Collectors.toMap(
                CollectorsAndComparators::getId,
                CollectorsAndComparators::getName,
                (existing, replacement) -> existing,
                LinkedHashMap::new
                )
        );
        
        System.out.println(output);

    }



    

    
    
}
