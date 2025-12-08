package DSA.Day_1;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] input = { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1 };
        int maxStreak = 0;

        int currentStreak = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] == 1) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    currentStreak = 0;
                }
            }
        }
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
        }
        System.out.println(maxStreak);

    }

}
