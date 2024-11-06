package StringManipulation;

/*
 * Create a method that checks if a given string is a palindrome
 * (reads the same forwards and backward), ignoring spaces, punctuation, and case.
 * For example, "A man, a plan, a canal: Panama" should return true.
 */

public class Palindrome {

    boolean isPalindrome(String input){
        boolean isPalindrome = false;

        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        String cleanString = sb.toString();

        int rightIndex = cleanString.length() -1;
        int leftIndex = 0;

        while(leftIndex < rightIndex){
            if(cleanString.charAt(leftIndex) != cleanString.charAt(rightIndex)){
                return isPalindrome;
            }

                leftIndex++;
                rightIndex--;

        }

        isPalindrome = true;
    
        return isPalindrome;
    }

    public static void main(String[] args) {
        Palindrome pd = new Palindrome();
        System.out.println(pd.isPalindrome("A man, a plan, a canal: Panama"));
    }
    
}
