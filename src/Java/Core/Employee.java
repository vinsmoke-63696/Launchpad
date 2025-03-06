package Java.Core;
public class Employee {

    public String name;
    public String department;
    public int salary;

    //constuctor
    public Employee(String name, String department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //overriden toString method to print that employee object
    @Override
    public String toString() {
        return "Employee - [" + " Name - " + name + " , Department - " + department +  " , Salary - " + salary + " ]" ;
    }

    //getters
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }   
}
