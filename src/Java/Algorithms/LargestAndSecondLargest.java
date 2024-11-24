package Java.Algorithms;

public class LargestAndSecondLargest {

    //find largest and second largest number from array

    public static void main(String[] args) {
        int[] array = {1,7,3,5,7,9,4};

        int largest = 0;
        int secondLargest = 0;
        for(int i = 0; i<array.length;i++){
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            }
        }

        System.out.println("Largest -" + largest);
        System.out.println("SecondLargest -" + secondLargest);

    }
    
}
