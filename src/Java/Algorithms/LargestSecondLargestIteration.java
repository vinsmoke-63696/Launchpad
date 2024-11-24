package Java.Algorithms;

/*
 * You're given an array of integer {1,2,3,5,7,9,4} you have to print all the iteration such that
 * in first iteration largest number is replaced with second largest number and so on
 * 1st iteration ->{1,2,3,5,7,7,4}
 * 2nd iteration ->{1,2,3,5,5,5,4}
 * last iteration->{1,1,1,1,1,1,1}
 */
import java.util.Arrays;
public class LargestSecondLargestIteration{

    //step 1 - need a while loop to keep iterating until first element is same as every other element
    //step 2 - find the largest and second largest number by iterating
    //step 3 - update largest number with second largest number
    //step 2 and 3 to be occured in loop

 public static void main(String[] args) {
    
    int[] array = {1,2,3,5,7,9,4};

    while(!isFirstNumberIsSameThroughout(array)){

        System.out.println(Arrays.toString(array));
        
        int largest = 0;
        int secondLargest = 0;
        for(int i = 0; i< array.length; i++){
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            }
            if(array[i] > secondLargest && array[i] < largest ){
                secondLargest = array[i];
            }
        }
        //swap
        for(int i = 0; i< array.length; i++){
            if(array[i] == largest){
                array[i] = secondLargest;
            }
        }
    }
    System.out.println(Arrays.toString(array));
 }
 
    static boolean isFirstNumberIsSameThroughout(int[] arr){
        for(int i = 0; i< arr.length; i++){
            if(arr[0] != arr[i]){
                return false;
            }
        }
        return true;
 }
}