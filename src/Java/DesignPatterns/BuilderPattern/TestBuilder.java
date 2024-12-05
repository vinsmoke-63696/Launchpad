package Java.DesignPatterns.BuilderPattern;

public class TestBuilder {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                        .setName("Sunig")
                        .setAge(27)
                        .setAddress("home address")
                        .build();

        System.out.println(person.getName() + " - " + person.getAge() + " - " + person.getAddress());
    }
    
}
