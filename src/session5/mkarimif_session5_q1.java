package session5;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session5_q1 {

    public static class Solution {

        private Solution() {

        }

        public static int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

    }

    public static void checkTestCase(final int testNumber, final int n, final int expected) {

        if (Solution.climbStairs(n) == expected) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {

        // Test 1 from the question
        checkTestCase(1, 2, 2);

        // Test 2 from the question
        checkTestCase(2, 3, 3);

        // Test 3
        checkTestCase(3, 4, 5);

        // Test 4
        checkTestCase(4, 10, 89);

        // Test 5
        checkTestCase(5, 35, 14930352);
    }

}