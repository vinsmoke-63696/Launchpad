
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SetInterface {

    public static void main(String[] args) {
        Set<String> fruits = new HashSet<String>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");
        fruits.add("Cherry");

        Iterator<String> iterator = fruits.iterator();
        //Iterate using iterator from Iterator Interface
        while(iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        //remove apple
        fruits.remove("Apple");
        for(String fruit : fruits){
            System.out.println(fruit);
        }

        //AddAll method
        Set<String> anotherSet = new HashSet<String>();
        anotherSet.add("Apple2");
        anotherSet.add("Banana2");
        anotherSet.add("Strawberry2");
        anotherSet.add("Cherry2");

        fruits.addAll(anotherSet);

        for (String fruit : anotherSet) {
            System.out.println(fruit);
        }
    }
    
}
