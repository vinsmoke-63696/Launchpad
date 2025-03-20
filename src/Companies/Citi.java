package Companies;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//stream problem to sort on lastName
//how to limit number of object creation
//create interface to have custom validation for columns in csv file. (eg. csv has 5 columns, name, age, dob, id, phoneNumber)
// then create a structure/validation framework to provide custom validation for all the columns
// output of following db query
/*Table T1
Col1
	1
	1
	1
 
Table T2
Col2
	1
	1
	1
	
	select * from T1,T2 where T1.Col1 = T2.col2
    select * from cardbin, routingTransitNbr where cardbin.fiIdentifier = routingTransitNbr.fiIdentifier
 
*/
public class Citi {



    
public static void main(String[] args) {
    List<String> list = Arrays.asList("Sunig Kale",
                                    "Anant Bhat",
                                    "Narendra Modi",
                                    "Devendra Fadanvis");
    list.stream().sorted(Comparator.comparing(s-> s.split(" ")[1]));
	//List.of()
 
}
}