package session5;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session5_q2 {

    public static class Solution {

        private Solution() {

        }

        public static int maxSubArray(int[] nums) {

            if (nums.length == 0) return 0;

            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] + nums[i] > nums[i]) {
                    nums[i] += nums[i - 1];
                }
                if (nums[i] > maxSum) maxSum = nums[i];
            }

            return maxSum;
        }
    }

    public static void checkTestCase(final int testNumber, final int[] arr, final int expected) {

        if (Solution.maxSubArray(arr) == expected) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {

        // Test 1 from the question
        checkTestCase(1, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);

        // Test 2
        checkTestCase(2, new int[]{1}, 1);

        // Test 3
        checkTestCase(3, new int[]{0}, 0);

        // Test 4
        checkTestCase(4, new int[]{-1}, -1);

        // Test 5
        checkTestCase(5, new int[]{-3, -5, 10, -2, 4}, 12);
    }

}