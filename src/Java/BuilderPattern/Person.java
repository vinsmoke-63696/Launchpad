package Java.BuilderPattern;

//Idea is whenever you set a value to any property you return the same builder instance, so that it will have the value
//and proceed with method chaining for next propery (this enables method chaining)

//At the end, have a build() method that will return final class object

//Builder class will only have set methods
//Person class will only have get methods

public class Person {

    private String name;
    private int age;
    private String address;

    private Person(Builder builder){

        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
        
    }

    public static class Builder{
        private String name;
        private int age;
        private String address;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
    
}
